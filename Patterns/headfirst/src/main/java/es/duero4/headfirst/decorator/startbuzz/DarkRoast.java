package es.duero4.headfirst.decorator.startbuzz;

/**
 *
 * @author ramon
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
