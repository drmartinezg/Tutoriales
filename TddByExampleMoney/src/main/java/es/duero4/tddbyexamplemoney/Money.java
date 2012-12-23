package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public abstract class Money {

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    protected int amount;
    protected String currency;
    
    abstract Money times(int multiplier);
    
    String currency(){
        return currency;
    }
    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return (amount == money.amount &&
                getClass().equals(money.getClass()));
    }
 
}
