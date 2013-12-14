package es.duero4.tddinactionjee.concurrency.threadsafety;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Ramon
 */
public class SynchedThread extends Thread {
    private CyclicBarrier entryBarrier;
    private CyclicBarrier exitBarrier;

    public SynchedThread(Runnable runnable, CyclicBarrier entryBarrier, CyclicBarrier exitBarrier) {
        super(runnable);
        this.entryBarrier = entryBarrier;
        this.exitBarrier = exitBarrier;
    }
    
    @Override
    public void run() {
        try {
            entryBarrier.await();       // Wait for others
            super.run();                // Execute logic
            exitBarrier.await();        // Indicate completion
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
