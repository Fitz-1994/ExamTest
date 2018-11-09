package thinkinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitTest {
    public static void main(String[] args) {
        FirstRun run1 = new FirstRun();
        Runnable run2 = new SecondRun(run1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(run1);
        exec.execute(run2);
        exec.shutdown();
    }
}
class FirstRun implements Runnable{
    public synchronized void waiting(){
        try {
            System.out.println("第一个run即将进入休眠");
            wait();
            System.out.println("第一个run被唤醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void notifying(){
        notifyAll();
    }
    @Override
    public void run() {
        waiting();
    }
}
class SecondRun implements Runnable{
    private FirstRun run;
    SecondRun(FirstRun r){
        this.run = r;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run.notifying();
    }
}
