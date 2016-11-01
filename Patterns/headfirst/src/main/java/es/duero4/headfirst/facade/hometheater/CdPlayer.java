package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class CdPlayer {
    private final String description;
    private final Amplifier amplifier;

    public CdPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }
    
}
