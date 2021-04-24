package leetcode.threads;

import java.util.concurrent.Semaphore;

public class Foo1 {
    Semaphore second = new Semaphore(1);
    Semaphore third = new Semaphore(1);

    public Foo1() {
        try {
            second.acquire();
            third.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
