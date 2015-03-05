package es.duero4.headfirst.factory.pizzafm;

/**
 *
 * @author ramon
 */
class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Chess Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        
        toppings.add("Shredded Mozzarella Cheese");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
