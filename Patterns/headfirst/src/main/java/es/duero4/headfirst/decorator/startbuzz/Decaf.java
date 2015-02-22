package es.duero4.headfirst.decorator.startbuzz;

/**
 *
 * @author ramon
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }
    
    @Override
    public double cost() {
        return 1.05;
    }
    
}
