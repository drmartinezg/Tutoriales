package es.duero4.headfirst.adapter.ducks;

/**
 *
 * @author ramon
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
    
}
