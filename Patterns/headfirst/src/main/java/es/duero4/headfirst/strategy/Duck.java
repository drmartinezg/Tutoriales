package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
public abstract class Duck {
    
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }
    
    public abstract void display();
    
    public void performFly() {
        flyBehavior.fly();
    }
    
    public void performQuack() {
        quackBehavior.quack();
    }
    
    public void swin() {
        System.out.println("All ducks float, even decoys!");
    }
}
