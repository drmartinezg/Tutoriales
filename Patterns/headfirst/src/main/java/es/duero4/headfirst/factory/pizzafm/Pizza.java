package es.duero4.headfirst.factory.pizzafm;

import es.duero4.headfirst.factory.pizzas.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramon
 */
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();
    
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dought...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }
    
    public void bake() {
        System.out.println("Baking for 25 minutes at 350");
    }
    
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("--" + name + "--\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }
}
