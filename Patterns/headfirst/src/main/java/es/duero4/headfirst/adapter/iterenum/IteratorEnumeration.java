package es.duero4.headfirst.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author ramon
 */
public class IteratorEnumeration implements Enumeration {
    Iterator iterator;

    public IteratorEnumeration(Iterator iterator) {
        this.iterator = iterator;
    }
        
    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
    
}
