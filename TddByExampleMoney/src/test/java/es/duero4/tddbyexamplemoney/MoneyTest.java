/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.duero4.tddbyexamplemoney;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 * 
 * Chapter 3 - Money Example
 * Chapter 4 - Degenerate Objects
 * Chapter 5 - Equality for All
 * 
 * TO-DO List:
 *    $5 + 10 CHF = $10 if rate is 2:1
 * OK $5 * 2 = $10
 * -> Make “amount” private
 * OK Dollar side-effects?
 *    Money rounding?
 * OK equals()
 *    hashCode()
 *    Equal null
 *    Equal object
 * 
 */
public class MoneyTest {
    
    public MoneyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }
    
    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}
