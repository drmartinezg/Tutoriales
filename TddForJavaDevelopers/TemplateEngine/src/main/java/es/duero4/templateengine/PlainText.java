package es.duero4.templateengine;

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
    
}
