package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression tenFrancs);
}
