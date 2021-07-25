package com.company.task5.chain;

import com.company.task5.entity.TextComposite;

public abstract class AbstractParser {
    private AbstractParser handler;

    public AbstractParser() {
    }

    public AbstractParser(AbstractParser handler) {
        this.handler = handler;
    }

    public AbstractParser getHandler() {
        return handler;
    }
    public abstract void parse(TextComposite composite, String part);
}
