package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.Symbol;
import com.company.task5.entity.TextComposite;

public class SymbolParser extends AbstractParser {

    @Override
    public void parse(TextComposite composite, String part) {
        for (int i = 0; i < part.length(); i++) {
            char ch = part.charAt(i);
            Symbol leaf = new Symbol(ch, ComponentType.LETTER);
            composite.add(leaf);
        }
    }
}
