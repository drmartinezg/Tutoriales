package es.duero4.templateengine;

/**
 *
 * @author Ramon
 */
public class MissingValueException extends RuntimeException {

    MissingValueException(String message) {
        super(message);
    }
}
