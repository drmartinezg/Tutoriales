package es.duero4.headfirst.templatemethod.barista;

/**
 *
 * @author ramon
 */
public abstract class CaffeineBeverageWithHook {
    
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    
    public abstract void brew();

    public abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boliling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public boolean customerWantsCondiments() {
        return true;
    }

}
