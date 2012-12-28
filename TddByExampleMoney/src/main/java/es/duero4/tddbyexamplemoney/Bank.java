/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.duero4.tddbyexamplemoney;

/**
 *
 * @author Ramon
 */
public class Bank {

    Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
    
}
