package thinkinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Forward
 * p660 练习6
 */
public class P660Test implements Runnable {
    private int id;
    P660Test(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(5*1000);
            System.out.println(id+"睡眠时间5秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new P660Test(i));
        }
        exec.shutdown();
    }
}
