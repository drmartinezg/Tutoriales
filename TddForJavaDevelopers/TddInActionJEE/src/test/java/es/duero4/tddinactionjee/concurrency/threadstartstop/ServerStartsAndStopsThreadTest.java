package es.duero4.tddinactionjee.concurrency.threadstartstop;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
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
public class ServerStartsAndStopsThreadTest {

    // 1 - Create custom thread and store for later reference.
    private StartStopSynchronizedThread thread;
    
    public ServerStartsAndStopsThreadTest() {
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
    public void testStartingAndStoppingServerThread() throws Exception {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable task) {
                thread = new StartStopSynchronizedThread(task);
                return thread;
            }
        };
        
        Server server = new Server();
        // 2- Configure Server with custom ThreadFactory
        server.setThreadFactory(threadFactory);
        
        server.start();
        
        // 3 - Use custom thread's latches to verify that thread is started/stopped.
        thread.waitForStarted(1, TimeUnit.SECONDS);
        server.stop();
        thread.waitForStopped(1, TimeUnit.SECONDS);
    }
}
