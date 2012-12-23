package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
class Franc extends Money {
    private String currency;

    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

    @Override
    String currency() {
        return currency;
    }

}
