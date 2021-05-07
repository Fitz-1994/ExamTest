package leetcode.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int flag = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                condition.await();
            }
            printFirst.run();
            flag++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                condition.await();
            }
            printSecond.run();
            flag++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                condition.await();
            }
            printThird.run();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
