package es.duero4.headfirst.command.remote;

/**
 *
 * @author ramon
 */
public class CeilingFan {
    String location = "";
    int level;
    private static final int HIGH = 2;
    private static final int MEDIUM = 1;
    private static final int LOW = 0;

    public CeilingFan(String location) {
        this.location = location;
    }
    
    public void high() {
        // turns the ceiling fan on to high
        level = HIGH;
        System.out.println(location + " ceiling fan is on high");
    }
    
    public void medium() {
        // turns the ceiling fan on to medium
        level = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
    }
    
    public void low() {
        // turns teh ceiling fan on to low
        level = LOW;
        System.out.println(location + " ceiling fan is on low");
    }
    
    public void off() {
        // turns the ceiling fan off
        level = 0;
        System.out.println(location + " ceiling fan is off");
    }
    
    public int getSpeed() {
        return level;
    }
}
