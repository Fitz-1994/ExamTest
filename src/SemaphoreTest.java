import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始申请资源");
                        semaphore.acquire();//申请资源
                        System.out.println(Thread.currentThread().getName() + "获取到资源，资源占领10秒");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //释放资源
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + "资源释放");
                    }

                }
            }, "线程" + i).start();
        }
    }
}
