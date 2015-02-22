package es.duero4.headfirst.decorator.startbuzz;

/**
 *
 * @author ramon
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
