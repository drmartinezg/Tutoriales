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
    
    @Test
    public void testForThreadSafety() throws Exception {
        final Counter codeUnderTest = new Counter();
        final int numberOfThreads = 20;
        final int incrementsPerThread = 100;
        
        Runnable runnable = new Runnable() {
           @Override
            public void run() {
                for (int i = 0; i < incrementsPerThread; i++) {
                   codeUnderTest.increment();
               }
            }
        };
        
        // 1 - Start threads
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(runnable).start();
        }
        
        // 2 - Wait for threads to finish and assert counter's value
        Thread.sleep(500);
        assertEquals(numberOfThreads * incrementsPerThread, codeUnderTest.value());
    }
}