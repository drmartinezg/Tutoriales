package es.duero4.tddinactionjee.concurrency.methodblocking;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ramon
 */
public class BlackMarket {
    private Semaphore tickets = new Semaphore(0);
    
    public BlackMarket() {
    }

    void buyTicket() throws InterruptedException {
        tickets.acquire();
    }

    public void sellTicket() {
        tickets.release();
    }
}
