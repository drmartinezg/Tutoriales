package es.duero4.tddinactionjee.concurrency.asynchexecution;

/**
 * This class allows you to assert a condition that may not be true right al the
 * moment, butshould become true within a specified time frame. To use it,
 * simple replace calls like:
 * 
 * assert(someCondition);
 * 
 * With:
 * 
 * new RetriedAssert(5000, 250) { // timeout, interval public void run() throws
 * Exception { assert(someCondition); } }.start();
 * 
 * The start() and run() methods were named after those in java.lang.Thread,
 * whose function they mimic.
 * 
 * This class was written by Model N, Inc. You may use it and modify ti any way
 * you wish--but please leave this message intact.
 * 
 * @author Kevin Bourrillion (kevin@modeln.com)
 */
public abstract class RetriedAssert {
    
    private int _timeOutMs;
    private int _intervalMs;

    protected RetriedAssert(int timeOutMs, int intervalMs) {
        this._timeOutMs = timeOutMs;
        this._intervalMs = intervalMs;
    }
    
    public final void start() throws Exception {
        long stopAt = System.currentTimeMillis() + _timeOutMs;
        while (System.currentTimeMillis() < stopAt) {            
            try {
                run();
                return;
            } catch (AssertionError ignoreAndRetry) {
            }
            try {
                Thread.sleep(_intervalMs);
            } catch (InterruptedException e) {
            }
        }
        // All tries have failed so far. Try one last time,
        // now letting any failure pass out to the caller.
        run();
    }

    public abstract void run() throws Exception;
}
