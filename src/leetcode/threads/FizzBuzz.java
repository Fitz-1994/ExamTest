package leetcode.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    boolean endFlag = false;
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore dou = new Semaphore(0);
    Semaphore num = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (!endFlag) {
            fizz.acquire();
            if (!endFlag) {
                printFizz.run();
                num.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (!endFlag) {
            buzz.acquire();
            if (!endFlag) {
                printBuzz.run();
                num.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (!endFlag) {
            dou.acquire();
            if (!endFlag) {
                printFizzBuzz.run();
                num.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        num.release();
        int _3 = 0;
        int _5 = 0;
        for (int i = 1; i <= n; i++) {
            _3++;
            _5++;
            num.acquire();
            if (_3 == 3 && _5 == 5) {
                dou.release();
                _3 = 0;
                _5 = 0;
            } else if (_3 == 3) {
                fizz.release();
                _3 = 0;
            } else if (_5 == 5) {
                buzz.release();
                _5 = 0;
            } else {
                printNumber.accept(i);
                num.release();
            }
        }
        num.acquire();
        endFlag = true;
        dou.release();
        fizz.release();
        buzz.release();
    }
}