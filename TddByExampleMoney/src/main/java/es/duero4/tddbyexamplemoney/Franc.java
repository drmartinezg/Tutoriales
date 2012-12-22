package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 * 
 */
class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }
    
    Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
