package es.duero4.headfirst.iterator.dinermergercafe;

import es.duero4.headfirst.iterator.dinermergeri.*;

/**
 *
 * @author ramon
 */
public class MenuItem {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return (name + ", $" + price + "\n " + description);
    }
    
}
