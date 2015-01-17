package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
public class Squeack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
    
}
