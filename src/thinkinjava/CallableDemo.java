package thinkinjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Forward
 * p658
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(exec.submit(new TaskWithResult(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                System.out.println(list.get(i).get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
class TaskWithResult implements Callable<String>{
    private int id;

    TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
//        Thread.sleep(1000*5);
        return "第"+id+"个任务已返回。";
    }
}
