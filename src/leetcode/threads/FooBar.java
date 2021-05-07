package leetcode.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    private boolean flag = true;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (!flag) {
                    condition.await();
                }
                printFoo.run();
                flag = false;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (flag) {
                    condition.await();
                }
                printBar.run();
                flag = true;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}