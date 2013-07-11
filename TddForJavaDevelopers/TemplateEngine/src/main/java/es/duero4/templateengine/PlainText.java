package es.duero4.templateengine;

import java.util.Map;

/**
 *
 * @author Ramon
 */
public class PlainText implements Segment {
    private final String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object other) {
        return text.equals(((PlainText) other).text);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return text;
    }
    
}
