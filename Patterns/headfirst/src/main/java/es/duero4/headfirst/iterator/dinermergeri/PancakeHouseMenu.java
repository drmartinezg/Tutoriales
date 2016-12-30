package es.duero4.headfirst.iterator.dinermergeri;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ramon
 */
public class PancakeHouseMenu {
    private ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        
        addItem("k&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true, 2.99);
        
        addItem("Regular Pancake Breakfast", 
                "Pancakes with fried eggs, sausage", 
                false, 2.99);
        
        addItem("Blueberry Pancakes", 
                "Pancakes made with fresh blueberries", 
                true, 3.49);
        
        addItem("Waffles", 
                "Waffles, with your choice of blueberries o strawberries", 
                true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
    
    public Iterator createIterator() {
        return menuItems.iterator();
    }
    
    @Override
    public String toString() {
        return "Objectville Pancake House Menu";
    }
    
}
