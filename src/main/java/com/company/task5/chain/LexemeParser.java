package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.Symbol;
import com.company.task5.entity.TextComposite;

public class LexemeParser extends AbstractParser {
    private static final String LEXEME_REGEX = "\\s";
    private static final String WORD_REGEX = "\\p{L}";
    private static final String PUNCTUATION_REGEX = "\\p{P}|\\p{M}|\\p{S}";


    @Override
    public void parse(TextComposite composite, String part) {

        String[] lexemes = part.split(LEXEME_REGEX);
        for (String lexeme : lexemes) {
            TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
            composite.add(lexemeComposite);
            for (int i = 0; i < lexeme.length(); i++) {
                char ch = lexeme.charAt(i);
                if (String.valueOf(ch).matches(PUNCTUATION_REGEX)) {
                    Symbol leaf = new Symbol(ch, ComponentType.SYMBOL);
                    composite.add(leaf);
                } else if (String.valueOf(ch).matches(WORD_REGEX)) {
                    Symbol leaf = new Symbol(ch, ComponentType.LETTER);
                    composite.add(leaf);
                }
            }
        }
    }
}


