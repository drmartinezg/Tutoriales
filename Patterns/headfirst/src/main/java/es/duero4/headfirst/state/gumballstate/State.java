package es.duero4.headfirst.state.gumballstate;

/**
 *
 * @author ramon
 */
public interface State {

    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
