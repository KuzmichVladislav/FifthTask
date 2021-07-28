package com.company.task5.entity;

import java.util.Collection;

public class Symbol extends TextComponent {
    private char ch;

    public Symbol(char ch, ComponentType componentType) {
        super(componentType);
        this.ch = ch;
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public boolean add(TextComponent component) {
        throw new UnsupportedOperationException("add impossible");
    }

    @Override
    public Collection<TextComponent> getChildren() {
       // logger.error("An attempt to get children of symbol");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return Character.toString(ch);
    }
}
