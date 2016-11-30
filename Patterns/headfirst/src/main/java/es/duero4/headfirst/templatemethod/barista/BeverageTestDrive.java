package es.duero4.headfirst.templatemethod.barista;

/**
 *
 * @author ramon
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        System.out.println("\nMaking tea...");
        tea.prepareRecipe();
        
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
        
        System.out.println("\n--------- With Hook --------");
        
        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        
        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();
        
        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();
    }
}
