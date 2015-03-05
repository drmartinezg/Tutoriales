package es.duero4.headfirst.factory.pizzafm;

/**
 *
 * @author ramon
 */
class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Chess Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        
        toppings.add("Grated Reggiano Cheese");
    }
    
}
