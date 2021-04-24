package leetcode.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

    Semaphore hSema = new Semaphore(2);
    Lock oLock = new ReentrantLock();
    CountDownLatch latch = new CountDownLatch(2);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        ;
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        latch.countDown();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            oLock.lock();
            latch.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            latch = new CountDownLatch(2);
            hSema.release(2);
        } finally {
            oLock.unlock();
        }
    }
}
