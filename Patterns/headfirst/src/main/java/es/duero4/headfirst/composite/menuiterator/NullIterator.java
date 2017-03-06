package es.duero4.headfirst.composite.menuiterator;

import java.util.Iterator;

/**
 *
 * @author ramon
 */
public class NullIterator implements Iterator {

    public NullIterator() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
