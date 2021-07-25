package com.company.task5.entity;

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
    public String toString() {
        return Character.toString(ch);
    }
}