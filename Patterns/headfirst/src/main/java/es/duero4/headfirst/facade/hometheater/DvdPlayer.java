package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class DvdPlayer {
    private final String description;
    private final Amplifier amplifier;
    private String movie;
    private int currentTrack;

    public DvdPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
    
    public void eject() {
        movie = null;
        System.out.println(description + " eject");
    }

    public void play(String movie) {
        this.movie = movie;
        currentTrack = 0;
        System.out.println(description + " playing \"" +  movie + "\"");
    }

    public void stop() {
        currentTrack = 0;
        System.out.println(description + " stopped \"" + movie + "\"");
    }

    @Override
    public String toString() {
        return description;
    }

}
