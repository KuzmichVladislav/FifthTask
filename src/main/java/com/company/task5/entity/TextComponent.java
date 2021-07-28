package com.company.task5.entity;

import java.util.Collection;

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

    public abstract Collection<TextComponent> getChildren();
}
