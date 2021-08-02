package com.company.task5.service;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComponent;
import com.company.task5.exception.CompositeException;

import java.util.*;
import java.util.regex.Pattern;

public class TextService {

    private static final String PUNCTUATION_REGEX = "[\\p{P}\\p{M}\\p{S}]";
    private static final String LETTERS_REGEX = "[aeiouаоуэиыеёяю]";

    public List<TextComponent> sortParagraphsBySentenceAmount(TextComponent text) {

        List<TextComponent> list = new ArrayList<>(text.getChildren());
        list.sort(new ParagraphComparator());
        return list;
    }

    public List<TextComponent> findSentencesWithLongestWord(TextComponent text) throws CompositeException {

        List<TextComponent> allSentences = new ArrayList<>();
        for (TextComponent paragraph : text.getChildren()) {
            allSentences.addAll(paragraph.getChildren());
        }

        boolean seen = false;
        Integer best = null;
        for (TextComponent allSentence : allSentences) {
            Integer computeMaxWordLength = computeMaxWordLength(allSentence);
            if (!seen || computeMaxWordLength.compareTo(best) > 0) {
                seen = true;
                best = computeMaxWordLength;
            }
        }
        int maxLength = (seen ? Optional.of(best) : Optional.<Integer>empty())
                .orElseThrow(() -> new CompositeException("Sentence contains no words"));

        List<TextComponent> sentencesWithLongestWord = new ArrayList<>();
        for (TextComponent sentence : allSentences) {
            if (computeMaxWordLength(sentence) == maxLength) {
                sentencesWithLongestWord.add(sentence);
            }
        }

        return sentencesWithLongestWord;
    }

    private int computeMaxWordLength(TextComponent sentence) {
        boolean seen = false;
        Integer best = null;
        for (TextComponent lexeme : sentence.getChildren()) {
            if (matchesType(lexeme, ComponentType.LEXEME)) {
                Integer size = lexeme.getChildren().size();
                if (!seen || size.compareTo(best) > 0) {
                    seen = true;
                    best = size;
                }
            }
        }

        return seen ? best : 0;
    }

    private boolean matchesType(TextComponent component, ComponentType type) {
        return component.getComponentType().equals(type);
    }

    public List<TextComponent> removeSentencesWithLessNumber(TextComponent text, int wordCount) {
        List<TextComponent> paragraphs = new ArrayList<>();
        for (TextComponent sentence : text.getChildren()) {
            if (matchesType(sentence, ComponentType.SENTENCE)) {
                paragraphs.add(sentence);
            }
        }

        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : paragraphs) {
            if (paragraph.getChildren().size() > wordCount) {
                result.add(paragraph);
            }
        }
        return result;
    }

    public Map<String, Integer> findIdenticalWords(TextComponent text) {

        Map<String, Integer> map = new HashMap<>();
        for (TextComponent component : text.getChildren()) {
            for (TextComponent word : component.getChildren()) {
                if (matchesType(word, ComponentType.LEXEME)) {
                    String key = word.toString().replaceAll(PUNCTUATION_REGEX, "").toLowerCase();
                    int occurrences = map.getOrDefault(key, 0);
                    map.put(key, ++occurrences);
                }
            }
        }
        return map;
    }

    public String countVowelsAndConsonants(TextComponent sentence) {

        long vowelsCount = 0L;
        for (TextComponent textComponent : sentence.getChildren()) {
            if (matchesType(textComponent, ComponentType.LEXEME)) {
                for (TextComponent letter1 : textComponent.getChildren()) {
                    if (Pattern.matches(LETTERS_REGEX, letter1.toString().replaceAll(PUNCTUATION_REGEX, "").toLowerCase())) {
                        vowelsCount++;
                    }
                }
            }
        }

        long consonantsCount = 0L;
        for (TextComponent component : sentence.getChildren()) {
            if (matchesType(component, ComponentType.LEXEME)) {
                for (TextComponent letter : component.getChildren()) {
                    if (!Pattern.matches(LETTERS_REGEX, letter.toString().replaceAll(PUNCTUATION_REGEX, "").toLowerCase())) {
                        consonantsCount++;
                    }
                }
            }
        }

        return "Count of vowels - " + vowelsCount + "\nCount of consonants  - " + consonantsCount;
    }

    private static class ParagraphComparator implements Comparator<TextComponent> {

        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            long firstCount = o1.getChildren().size();
            long secondCount = o2.getChildren().size();

            return Long.compare(firstCount, secondCount);
        }
    }
}
