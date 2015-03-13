package es.duero4.headfirst.factory.pizzaaf;

/**
 *
 * @author ramon
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();
    
}
