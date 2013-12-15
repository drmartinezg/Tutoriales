package es.duero4.tddinactionjee.concurrency.threadstartstop;

import java.util.concurrent.*;
import static junit.framework.Assert.*;

/**
 *
 * @author Ramon
 */
public class StartStopSynchronizedThread extends Thread {
    private CountDownLatch threadStarted;
    private CountDownLatch threadStopped;

    public StartStopSynchronizedThread(Runnable task) {
        super(task);
        threadStarted = new CountDownLatch(1);
        threadStopped = new CountDownLatch(1);
    }
    
    @Override
    public void run() {
        // 1 - Trigger latches when thread starts and stops
        threadStarted.countDown();
        super.run();
        threadStopped.countDown();
    }
    
    // 2 - Provide methods that block until thread starts / stops
    public void waitForStarted(long timeout, TimeUnit unit) throws InterruptedException {
        assertTrue("Thread not started within timeout.", threadStarted.await(timeout, unit));
    }
    
    public void waitForStopped(int timeout, TimeUnit unit) throws InterruptedException {
        assertTrue("Thread not stopped within timeout.", threadStopped.await(timeout, unit));
    }
}
