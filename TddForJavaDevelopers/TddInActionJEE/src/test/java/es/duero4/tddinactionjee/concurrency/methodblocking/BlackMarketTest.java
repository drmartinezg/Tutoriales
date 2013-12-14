package es.duero4.tddinactionjee.concurrency.methodblocking;

import java.util.concurrent.atomic.AtomicBoolean;
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
public class BlackMarketTest {
    
    public BlackMarketTest() {
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
    public void testBlockingBehavior() throws Exception {
        final AtomicBoolean blocked = new AtomicBoolean(true);
        
        Thread buyer = new Thread() {
            @ Override
            public void run() {
                try {
                    // 1 - Invoke blocking method in another thread
                    new BlackMarket().buyTicket();
                    // 2 - Set flag if method suceeded
                    blocked.set(false);
                } catch (InterruptedException expected) {
                }
            }
        };
        
        // 3 - Start thread, wait and interrupt
        buyer.start();
        Thread.sleep(1000);
        buyer.interrupt();
        buyer.join(1000);
        
        // 4 - Assert expected behavior
        assertFalse("Thread didn't interrrupt!", buyer.isAlive());
        assertTrue("Method didn't block!", blocked.get());
    }
}
