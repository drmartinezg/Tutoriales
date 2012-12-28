package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public class Sum implements Expression {
    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
    
}
