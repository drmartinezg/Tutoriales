package es.duero4.headfirst.factory.pizzafm;

/**
 *
 * @author ramon
 */
class ChicagoStyleVeggiePizza extends Pizza {

    public ChicagoStyleVeggiePizza() {
        name = "Chicago Style Dish Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        
        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
