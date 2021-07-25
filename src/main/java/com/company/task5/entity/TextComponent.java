package com.company.task5.entity;

public abstract class TextComponent {

    final ComponentType componentType;

    public TextComponent(ComponentType componentType) {
        this.componentType = componentType;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    abstract int count();

    abstract boolean add(TextComponent component);

}
