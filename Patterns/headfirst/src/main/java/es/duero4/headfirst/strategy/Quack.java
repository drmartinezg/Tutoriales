package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
    
}
