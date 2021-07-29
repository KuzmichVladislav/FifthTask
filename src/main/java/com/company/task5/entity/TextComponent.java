package com.company.task5.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class TextComponent {
    private List<TextComponent> components = new ArrayList<>();
    final ComponentType componentType;

    public TextComponent(ComponentType componentType) {
        this.componentType = componentType;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public int count(){
        int counter = 0;
        for (TextComponent element : components) {
            counter += element.count();
        }
        return counter;
    }

    abstract boolean add(TextComponent component);

    public abstract List<TextComponent> getChildren();
}
