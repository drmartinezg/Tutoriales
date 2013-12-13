package es.duero4.tddinactionjee.concurrency.threadsafety;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class ThreadSafetyTest {
    
    public ThreadSafetyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBasicFuncionality() throws Exception {
        Counter counter = new Counter();
        assertEquals(0, counter.value());
        counter.increment();
        assertEquals(1, counter.value());
        counter.increment();
        assertEquals(2, counter.value());
    }
}
