package es.duero4.headfirst.iterator.dinermerger;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class PancakeHouseIterator implements Iterator {
    private ArrayList items;
    private int position = 0;

    public PancakeHouseIterator(ArrayList items) {
        this.items = items;
    }
    

    @Override
    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object object = items.get(position);
        position = position + 1;
        return object;
    }
    
}
