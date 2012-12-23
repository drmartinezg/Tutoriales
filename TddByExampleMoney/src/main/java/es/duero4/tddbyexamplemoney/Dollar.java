package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
class Dollar extends Money {
    private String currency;

    Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

    @Override
    String currency() {
        return currency;
    }

}
