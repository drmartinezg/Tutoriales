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
 * Chapter 11 - Times We're Livin' In
 * 
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
 *    Dollar/Franc duplication
 * OK Common equals
 *    Common times
 * OK Compare Francs to Dollars
 * -> Currency?
 *    Delete testFrancMultiplication?
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
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }
    
    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }
    
    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
    
    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
}
