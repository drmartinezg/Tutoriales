package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public class Money implements Expression {

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    protected int amount;
    protected String currency;
    
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    };
    
    public String currency(){
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

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

}
