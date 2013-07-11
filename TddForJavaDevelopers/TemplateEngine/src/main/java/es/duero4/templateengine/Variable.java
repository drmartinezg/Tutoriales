package es.duero4.templateengine;

import es.duero4.templateengine.Segment;
import java.util.Map;

/**
 *
 * @author Ramon
 */
public class Variable implements Segment {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object other) {
        return name.equals(((Variable) other).name);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return variables.get(name);
    }
}
