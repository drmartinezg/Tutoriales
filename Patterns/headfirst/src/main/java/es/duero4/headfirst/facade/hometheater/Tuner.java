package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class Tuner {
    private final String description;
    private final Amplifier amplifier;

    public Tuner(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

}
