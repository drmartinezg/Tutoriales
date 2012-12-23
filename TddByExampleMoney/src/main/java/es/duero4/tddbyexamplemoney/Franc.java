package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
public class Franc extends Money {

    public Franc(int amount, String currency) {
        super(amount, currency);
    }
    
    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    String currency() {
        return currency;
    }

}
