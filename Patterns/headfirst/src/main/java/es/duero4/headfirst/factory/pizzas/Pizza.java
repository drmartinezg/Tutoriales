package es.duero4.headfirst.factory.pizzas;

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
    
    public String getName() {
        return name;
    }
    
    public void prepare() {
        System.out.println("Preparing " + name);
    }
    
    public void bake() {
        System.out.println("Baking " + name);
    }
    
    public void cut() {
        System.out.println("Cutting " + name);
    }
    
    public void box() {
        System.out.println("Boxing " + name);
    }
    
    @Override
    public String toString() {
        // code to display pizza name and ingredients
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
