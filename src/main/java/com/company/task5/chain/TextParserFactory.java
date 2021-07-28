package com.company.task5.chain;

public class TextParserFactory {
    private TextParserFactory() {

    }

    public static AbstractParser createParser() {
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);

        return paragraphParser;
    }
}
