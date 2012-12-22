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
 * Chapter 6 - Privacy
 * Chapter 7 - Franc-ly Speaking
 * Chapter 8 - Equality for All, Redux
 * Chapter 9 - Apples and Oranges
 * Chapter 10 - Makin' Objects
 * 
 * TO-DO List:
 *    $5 + 10 CHF = $10 if rate is 2:1
 * OK $5 * 2 = $10
 * OK Make “amount” private
 * OK Dollar side-effects?
 *    Money rounding?
 * OK equals()
 *    hashCode()
 *    Equal null
 *    Equal object
 * OK 5 CHF * 2 = 10 CHF
 * -> Dollar/Franc duplication
 * OK Common equals
 *    Common times
 * OK Compare Francs to Dollars
 *    Currency?
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
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
    
    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(new Dollar(5)));
    }
}
