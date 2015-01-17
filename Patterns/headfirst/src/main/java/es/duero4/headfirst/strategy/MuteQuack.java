package es.duero4.headfirst.strategy;

/**
 *
 * @author ramon
 */
public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
    
}
