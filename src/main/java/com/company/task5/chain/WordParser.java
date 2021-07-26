package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComponent;
import com.company.task5.entity.TextComposite;

import java.util.List;

public class WordParser extends AbstractParser {
    public WordParser() {
        super(new SymbolParser());
    }

    public WordParser(TextComposite component, String word) {
        parse(component, word);
    }

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> listWords = List.of(part.split("\\s+"));
        for (String word : listWords) {
            TextComposite wordComposite = new TextComposite(ComponentType.LETTER);
            composite.add(wordComposite);
            getHandler().parse(composite, word);
        }
    }
}
