package com.company.task5.entity;

public enum ComponentType {
    TEXT,
    PARAGRAPH("", "\r\n"),
    SENTENCE("", ""),
    LEXEME(" ", ""),
    SYMBOL,
    LETTER;

    private String prefix = "";
    private String suffix = "";

    ComponentType() {
    }

    ComponentType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

}
