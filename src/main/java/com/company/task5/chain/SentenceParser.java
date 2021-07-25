package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComposite;

import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String SENTENCE_SPLIT_REGEX = "(?<=\\.{3}|\\.|\\?|!)\\s";
    public SentenceParser() {
        super(new LexemeParser());
    }

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> listSentences = List.of(part.split(SENTENCE_SPLIT_REGEX));
        for (String sentence : listSentences) {
            TextComposite wordComposite = new TextComposite(ComponentType.SENTENCE);
            composite.add(wordComposite);
            getHandler().parse(composite, sentence);
        }
    }
}
