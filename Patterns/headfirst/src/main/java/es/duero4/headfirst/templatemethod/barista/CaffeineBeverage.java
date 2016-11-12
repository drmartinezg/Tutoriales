package es.duero4.headfirst.templatemethod.barista;

/**
 *
 * @author ramon
 */
public abstract class CaffeineBeverage {
    
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public abstract void brew();

    public abstract void addCondiments();
    
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

}
