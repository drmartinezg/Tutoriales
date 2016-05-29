package es.duero4.headfirst.command.party;

/**
 *
 * @author ramon
 */
class TV {
    private String location;
    
    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is on");
    }
    
    public void off() {
        System.out.println(location + " TV is off");
    }
    
    public void setInputChannel() {
        System.out.println(location + " TV channel is set for DVD");
    }
}
