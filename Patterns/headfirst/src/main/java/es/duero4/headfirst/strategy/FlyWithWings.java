package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
    
}
