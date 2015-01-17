package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
    
}
