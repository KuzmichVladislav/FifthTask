package com.company.task5.chain;

public class TextParserFactory {
    private TextParserFactory() {

    }

    public static AbstractParser createParser() {
        SymbolParser symbolParser = new SymbolParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(symbolParser);

        return paragraphParser;
    }
}
