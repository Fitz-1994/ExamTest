package thread;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("执行run方法，当前线程号是"+Thread.currentThread());
        super.run();
    }

    @Override
    public synchronized void start() {
        System.out.println("执行start方法，当前线程号是"+ Thread.currentThread());
        super.start();
    }
}
