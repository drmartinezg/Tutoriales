package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
public class Dollar extends Money {

    Dollar(int amount, String currency) {
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
