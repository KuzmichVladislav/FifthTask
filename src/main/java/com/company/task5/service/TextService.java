package com.company.task5.service;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComponent;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextService {
    public List<TextComponent> sortParagraphsBySentenceAmount(TextComponent text) {
        List<TextComponent> sortedParagraphs = text.getChildren()
                .stream()
                .sorted(new ParagraphComparator())
                .collect(Collectors.toList());

        return sortedParagraphs;
    }

    public List<TextComponent> findSentencesWithLongestWord(TextComponent text) throws Exception {

        List<TextComponent> allSentences = text.getChildren()
                .stream() // stream of paragraphs
                .flatMap(paragraph -> paragraph.getChildren().stream()) // stream of sentences
                .collect(Collectors.toList());

        int maxLength = allSentences.stream()
                .map(this::computeMaxWordLength)
                .max(Integer::compareTo)
                .orElseThrow(() -> new Exception("Sentence contains no words"));

        List<TextComponent> sentencesWithLongestWord = allSentences.stream()
                .filter(sentence -> computeMaxWordLength(sentence) == maxLength)
                .collect(Collectors.toList());

        return sentencesWithLongestWord;
    }

    private int computeMaxWordLength(TextComponent sentence) {
        int maxLength = sentence.getChildren()
                .stream() // stream of lexemes
                .map(word -> word.getChildren().size())
                .max(Integer::compareTo)
                .orElse(0);

        return maxLength;
    }

    private boolean matchesType(TextComponent component, ComponentType type) {
        return component.getComponentType().equals(type);
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
