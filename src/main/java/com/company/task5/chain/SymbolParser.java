package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.Symbol;
import com.company.task5.entity.TextComposite;

public class SymbolParser extends AbstractParser {

    private static final String PUNCTUATION_REGEX = "\\p{P}|\\p{M}|\\p{S}";
    private static final String WORD_REGEX = "\\p{L}";

    @Override
    public void parse(TextComposite composite, String part) {

        char[] lexemes = part.toCharArray();
        for (char ch : lexemes) {
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
