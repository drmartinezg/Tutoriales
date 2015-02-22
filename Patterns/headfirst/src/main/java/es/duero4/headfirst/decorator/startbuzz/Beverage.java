package es.duero4.headfirst.decorator.startbuzz;

/**
 *
 * @author ramon
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    
    public String getDescription() {
        return description;
    }
    
    public abstract double cost();
}
