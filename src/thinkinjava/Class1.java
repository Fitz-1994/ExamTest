package thinkinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Forward
 * p656 练习1
 * 多线程。并发
 */
public class Class1 implements Runnable {

    Class1(){
        System.out.println("Class1类初始化");
    }

    @Override
    public void run() {
        System.out.println("Runnable中的run方法第1次调用");
        Thread.yield();
        System.out.println("Runnable中的run方法第2次调用");
        Thread.yield();
        System.out.println("Runnable中的run方法第3次调用");
        Thread.yield();
        System.out.println("Runnable中的run方法结束");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Class1());
        }
        executorService.shutdown();
    }
}
