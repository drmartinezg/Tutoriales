package es.duero4.refactoring.chapter1;

/**
 *
 * @author ramon
 */
public class NewReleasePrice extends Price{

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
