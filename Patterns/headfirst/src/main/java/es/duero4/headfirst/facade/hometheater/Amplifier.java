package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class Amplifier {
    private final String description;
    private DvdPlayer dvd;

    public Amplifier(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
    
    public void setSurroundSound() {
        System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolumen(int level) {
        System.out.println(description + " setting volume to " + level);
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println(description + " setting DVD player to " + dvd);
        this.dvd = dvd;
    }

}
