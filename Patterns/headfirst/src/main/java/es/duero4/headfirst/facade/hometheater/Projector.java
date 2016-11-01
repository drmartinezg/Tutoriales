package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class Projector {
    private final String description;
    private final DvdPlayer dvdPlayer;

    public Projector(String description, DvdPlayer dvdPlayer) {
        this.description = description;
        this.dvdPlayer = dvdPlayer;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
    
    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    @Override
    public String toString() {
        return description;
    }

    
}
