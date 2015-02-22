package es.duero4.headfirst.decorator.startbuzz;

/**
 *
 * @author ramon
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }

}
