package com.company.task5.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends TextComponent {
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(ComponentType componentType) {
        super(componentType);
    }

    @Override
    public int count() {
        int counter = 0;
        for (TextComponent element : components) {
            counter += element.count();
        }
        return counter;
    }

    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        components.forEach(component -> {
            ComponentType type = component.getComponentType();
            String prefix = type.getPrefix();
            String suffix = type.getSuffix();
            stringBuilder.append(prefix).append(component).append(suffix);
        });

        return stringBuilder.toString().stripTrailing();
    }
}

