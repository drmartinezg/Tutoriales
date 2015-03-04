package es.duero4.headfirst.factory.pizzas;

/**
 *
 * @author ramon
 */
class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
    
}
