package es.duero4.refactoring.chapter1;

/**
 *
 * @author ramon
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
    
}
