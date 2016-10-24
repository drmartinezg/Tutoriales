package es.duero4.headfirst.adapter.iterenum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author ramon
 */
public class EnumerationIteratorTestDrive {
    public static void main(String[] args) {
        Vector v = new Vector(Arrays.asList(args));
        Iterator iterator = new EnumerationIterator(v.elements());
        while (iterator.hasNext()) {            
            System.out.println("iterator.next()");
        }
    }
    
}
