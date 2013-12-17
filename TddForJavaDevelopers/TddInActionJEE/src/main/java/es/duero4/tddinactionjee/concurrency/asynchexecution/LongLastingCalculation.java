package es.duero4.tddinactionjee.concurrency.asynchexecution;

/**
 *
 * @author Ramon
 */
public class LongLastingCalculation {
    private volatile Integer result;

    public Integer getResult() {
        return result;
    }
    
    public void start() {
        new Thread() {
          @Override
          public void run() {
              try {
                  Thread.sleep(1000);
                  result = 42;
              } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
          }
        }.start();
    }
}
