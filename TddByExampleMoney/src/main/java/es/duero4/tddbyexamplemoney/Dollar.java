package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
class Dollar extends Money {

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        Dollar dollar = (Dollar) obj;
        return amount == dollar.amount;
    }
    
}
