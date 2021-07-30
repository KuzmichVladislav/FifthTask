/*
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
 */
package com.company.task5.chain;

import com.company.task5.entity.TextComposite;

public abstract class AbstractParser {

    protected AbstractParser nextParser = DefaultParser.getParser();

    public void setNextParser(AbstractParser textParser) {
        this.nextParser = textParser;
    }

    public abstract void parse(TextComposite composite, String part);

    private static class DefaultParser extends AbstractParser {

        private static final DefaultParser parser = new DefaultParser();

        public static DefaultParser getParser() {
            return parser;
        }

        @Override
        public void parse(TextComposite composite, String part) {

        }
    }
}
