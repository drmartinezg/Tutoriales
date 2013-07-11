package es.duero4.templateengine;

import java.util.Map;

/**
 *
 * @author Ramon
 */
public interface Segment {
    String evaluate(Map<String, String> variables);
}
