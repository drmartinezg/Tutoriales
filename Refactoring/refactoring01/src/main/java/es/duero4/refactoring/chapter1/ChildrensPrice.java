package es.duero4.refactoring.chapter1;

/**
 *
 * @author ramon
 */
public class ChildrensPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
    
}
