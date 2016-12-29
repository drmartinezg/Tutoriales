package es.duero4.headfirst.iterator.dinermerger;

import java.util.ArrayList;

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
    
// We're not going to need this method anymore and in fact, we don't want it
// because it exposes out internal implementation!
    public ArrayList getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return new PancakeHouseIterator(menuItems);
    }
    
    @Override
    public String toString() {
        return "Objectville Pancake House Menu";
    }
    
}
