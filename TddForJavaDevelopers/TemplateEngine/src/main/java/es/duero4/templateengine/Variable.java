package es.duero4.templateengine;

import es.duero4.templateengine.Segment;

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
}
