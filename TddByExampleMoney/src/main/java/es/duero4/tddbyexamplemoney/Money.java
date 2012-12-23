package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public abstract class Money {

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    protected int amount;
    
    abstract Money times(int multiplier);
    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return (amount == money.amount &&
                getClass().equals(money.getClass()));
    }
 
}
