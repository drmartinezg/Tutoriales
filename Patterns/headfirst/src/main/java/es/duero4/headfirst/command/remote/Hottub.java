package es.duero4.headfirst.command.remote;

/**
 *
 * @author ramon
 */
public class Hottub {
    private boolean on;
    private int temperature;

    public Hottub() {
    }
    
    public void on() {
        on = true;
    }
    
    public void off() {
        on = false;
    }
    
    public void bubblesOn() {
        if (on) {
            System.out.println("Hottub is bubbling");
        }
    }
    
    public void bubblesOff() {
        if (!on) {
            System.out.println("Hottub is not bubbling");
        }
    }
    
    public void jetsOn() {
        if (on) {
            System.out.println("Hottub jets are on");
        }
    }
    
    public void jetsOff() {
        if (!on) {
            System.out.println("Hottub jets are off");
        }
    }
    
    public void heat() {
        temperature = 105;
        System.out.println("Hottub is heating to a steaming 105 degrees");
    }
    
    public void cool() {
        temperature = 98;
        System.out.println("Hottub is cooling to 98 degrees");
    }
    
}
