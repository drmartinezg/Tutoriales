package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public class Money {
    protected int amount;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return (amount == money.amount &&
                getClass().equals(money.getClass()));
    }
 
}
