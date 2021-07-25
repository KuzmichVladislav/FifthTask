package com.company.task5.chain;

import com.company.task5.entity.ComponentType;
import com.company.task5.entity.Symbol;
import com.company.task5.entity.TextComponent;
import com.company.task5.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String LEXEME_REGEX = "\\s";
    private static final String WORD_REGEX = "[^.!?,]+";
    private static final String PUNCTUATION_REGEX = "\\.|!|\\?|\\.{3}|,";

    public LexemeParser() {
        super(new SymbolParser());
    }

    @Override
    public void parse(TextComposite composite, String part) {
        String[] lexemes = part.split(LEXEME_REGEX);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);

        for (String lexeme : lexemes) {
            Matcher wordMatcher = wordPattern.matcher(lexeme);
            Matcher punctuationMatcher = punctuationPattern.matcher(lexeme);

            while (wordMatcher.find()) {
                String word = wordMatcher.group();
                TextComponent lexemeComponent = new TextComposite(ComponentType.WORD);
                composite.add(lexemeComponent);
                getHandler().parse(composite, word);
            }

            while (punctuationMatcher.find()) {
                String punctuation = punctuationMatcher.group();
                TextComponent lexemeComponent = new Symbol(punctuation.charAt(0), ComponentType.SYMBOL);
                composite.add(lexemeComponent);
            }
        }
    }
}

