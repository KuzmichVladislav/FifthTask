package com.company.task5.service;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComponent;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextService {

    public List<TextComponent> sortParagraphsBySentenceAmount(TextComponent text) {

        return text.getChildren()
                .stream()
                .sorted(new ParagraphComparator())
                .collect(Collectors.toList());
    }

    public List<TextComponent> findSentencesWithLongestWord(TextComponent text) throws Exception {

        int maxLength = text.getChildren().stream()
                .map(this::computeMaxWordLength)
                .max(Integer::compareTo)
                .orElseThrow(() -> new Exception("Sentence contains no words"));

        return text.getChildren().stream()
                .filter(sentence -> computeMaxWordLength(sentence) == maxLength)
                .collect(Collectors.toList());
    }

    private int computeMaxWordLength(TextComponent sentence) {
        int maxLength = sentence.getChildren()
                .stream() // stream of lexemes
                .filter(lexeme -> matchesType(lexeme, ComponentType.LEXEME))
                .map(word -> word.getChildren().size())
                .max(Integer::compareTo)
                .orElse(0);
        //System.out.println(sentence.getComponentType());

        return maxLength;
    }

    private boolean matchesType(TextComponent component, ComponentType type) {
        // System.out.println(component.getComponentType());
        return component.getComponentType().equals(type);
    }

    public List<TextComponent> removeSentencesWithLessNumber(TextComponent text, int wordСount) {
        List<TextComponent> paragraphs = text.getChildren()
                .stream().filter(sentence -> matchesType(sentence, ComponentType.SENTENCE))
                .collect(Collectors.toList());

        List<TextComponent> result = new ArrayList<>();
        for (int i = 0; i < paragraphs.size(); i++) {
            System.out.println(paragraphs.get(i).getChildren().size());
            if (paragraphs.get(i).getChildren().size() > wordСount) {
                System.out.println(paragraphs.get(i));
                result.add(paragraphs.get(i));
            }
        }
        return result;
    }

    public Map<String, Integer> findIdenticalWords(TextComponent text) {

        Map<String, Integer> map = new HashMap<>();
        text.getChildren()
                .stream()
                .flatMap(component -> component.getChildren().stream())
                .filter(component -> matchesType(component, ComponentType.LEXEME))
                .forEach(word -> {
                    String key = word.toString().replaceAll("\\p{P}|\\p{M}|\\p{S}", "").toLowerCase();
                    int occurrences = map.getOrDefault(key, 0);
                    map.put(key, ++occurrences);
                });
        return map;
    }

    public String countVowelsAndConsonants(TextComponent sentence) {

        long vowelsCount = sentence.getChildren()
                .stream()
                .filter(component -> matchesType(component, ComponentType.LEXEME))
                .flatMap(component -> component.getChildren().stream())
                .filter(letter -> Pattern.matches("[aeiouаоуэиыеёяю]", letter.toString().replaceAll("\\p{P}|\\p{M}|\\p{S}", "").toLowerCase()))
                .count();

        long consonantsCount = sentence.getChildren()
                .stream()
                .filter(component -> matchesType(component, ComponentType.LEXEME))
                .flatMap(component -> component.getChildren().stream())
                .filter(letter -> !Pattern.matches("[aeiouаоуэиыеёяю]", letter.toString().replaceAll("\\p{P}|\\p{M}|\\p{S}", "").toLowerCase()))
                .count();

        return "Сount of vowels - " + vowelsCount + "\nСount of consonants  - " + consonantsCount;
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
