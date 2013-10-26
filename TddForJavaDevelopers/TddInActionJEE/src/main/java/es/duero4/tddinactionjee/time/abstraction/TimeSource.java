package es.duero4.tddinactionjee.time.abstraction;

/**
 *
 * @author Ramon
 */
public interface TimeSource {

    /**
     * Returns the current time in millisenconds from epoch.
     */
    long millis();
}
