package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public class Money {

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    protected int amount;
    protected String currency;
    
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    public Money times(int amount) {
        return null;
    };
    
    String currency(){
        return currency;
    }
    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return (amount == money.amount &&
                currency().equals(money.currency()));
    }

    @Override
    public String toString() {
        return amount + " " + currency ;
    }

    
}
