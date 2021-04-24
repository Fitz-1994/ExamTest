package leetcode.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private volatile int i = 0;
    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(1);
    Semaphore odd = new Semaphore(1);


    public ZeroEvenOdd(int n) {
        this.n = n;
        try {
            even.acquire();
            odd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            zero.acquire();
            if (i < n) {
                printNumber.accept(0);
            }
            i++;
            if (i % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }
        even.release();
        odd.release();

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            even.acquire();
            if (i <= n) {
                printNumber.accept(i);
                zero.release();
            } else {
                break;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            odd.acquire();
            if (i <= n) {
                printNumber.accept(i);
                zero.release();
            } else {
                break;
            }
        }
    }
}
