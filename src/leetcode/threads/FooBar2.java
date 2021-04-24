package leetcode.threads;

import java.util.concurrent.Semaphore;

class FooBar2 {
    private int n;
    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(1);

    public FooBar2(int n) {
        this.n = n;
        try {
            bar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}