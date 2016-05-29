package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
class Hottub {
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
    
    public void circulate() {
        if (on) {
            System.out.println("Hottub is bubbling!");
        }
    }
    
    public void jetsOn() {
        if (on) {
            System.out.println("Hottub jets are on");
        }
    }
    
    public void jetsOff() {
        if (on) {
            System.out.println("Hottub jets are off");
        }
    }
    
    public void setTemperature(int temperature) {
        if (temperature > this.temperature) {
            System.out.println("Hottub is heating to a streaming " + temperature + " degrees");
        } else {
            System.out.println("Hottub is cooling to " + temperature + " degrees");
        }
        this.temperature = temperature;
    }
}
