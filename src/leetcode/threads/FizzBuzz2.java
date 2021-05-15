package leetcode.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz2 {
    private int n;
    private volatile int i = 1;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (i <= n) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}