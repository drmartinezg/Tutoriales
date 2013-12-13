package es.duero4.tddinactionjee.concurrency.threadsafety;

/**
 *
 * @author Ramon
 */
public class Counter {
    private int counter;

    public void increment() {
        counter++;
    }
    
    public int value() {
        return counter;
    }

}
