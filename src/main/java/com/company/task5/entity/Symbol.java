package com.company.task5.entity;

import java.util.List;

public class Symbol extends TextComponent {

    private final char characterSymbol;

    public Symbol(char characterSymbol, ComponentType componentType) {
        super(componentType);
        this.characterSymbol = characterSymbol;
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
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException("Symbol cannot contain anything");
    }

    @Override
    public String toString() {
        return Character.toString(characterSymbol);
    }
}
