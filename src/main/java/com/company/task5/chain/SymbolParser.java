package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.Symbol;
import com.company.task5.entity.TextComposite;

public class SymbolParser extends AbstractParser {
    private static final String LEXEME_REGEX = "\\s";
    private static final String WORD_REGEX = "\\p{L}";
    private static final String PUNCTUATION_REGEX = "\\p{P}|\\p{M}|\\p{S}";


    @Override
    public void parse(TextComposite composite, String part) {

        char[] lexemes = part.toCharArray();
        for (int i = 0; i < lexemes.length; i++) {
            char ch = lexemes[i];
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

