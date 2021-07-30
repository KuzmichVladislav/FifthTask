package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.TextComposite;

import java.util.List;

public class ParagraphParser extends AbstractParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "[\\t\\n]+";

    @Override
    public void parse(TextComposite composite, String part) {
        List<String> listParagraph = List.of(part.split(PARAGRAPH_SPLIT_REGEX));
        for (String paragraph : listParagraph) {
            TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
            composite.add(paragraphComposite);
            nextParser.parse(composite, paragraph);
        }
    }
}
