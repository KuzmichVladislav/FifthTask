package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComposite;

import java.util.List;

public class LexemeParser extends AbstractParser {

    private static final String LEXEME_REGEX = "\\s";

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> lexemes = List.of(part.split(LEXEME_REGEX));
        for (String lexeme : lexemes) {
            TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
            composite.add(lexemeComposite);
            nextParser.parse(lexemeComposite, lexeme);
        }
    }
}
