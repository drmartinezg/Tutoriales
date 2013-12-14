package es.duero4.tddinactionjee.concurrency.threadsafety;

import java.util.concurrent.CyclicBarrier;
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
    
    @Test
    public void testForThreadSafetyUsingCyclicBarrierToMaximizeConcurrency() throws Exception {
        final Counter codeUnderTest = new Counter();
        final int numberOfThreads = 20;
        final int incrementsPerThread = 1000;
        
        // 1 - Create barrier for all created threads plus courrent one.
        CyclicBarrier entryBarrier = new CyclicBarrier(numberOfThreads + 1);
        CyclicBarrier exitBarrier = new CyclicBarrier(numberOfThreads + 1);
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < incrementsPerThread; i++) {
                    codeUnderTest.increment();
                }
            }
        };
        
        // 2 - Custom Thread implementation waits on barrier
        for (int i = 0; i < numberOfThreads; i++) {
            new SynchedThread(runnable, entryBarrier, exitBarrier).start();
        }
        
        assertEquals(0, codeUnderTest.value());
        // 3 - Threads begin executing logic
        entryBarrier.await();
        // 4 - Wait for all threads to finish
        exitBarrier.await();
        assertEquals(numberOfThreads * incrementsPerThread, codeUnderTest.value());
    }
}