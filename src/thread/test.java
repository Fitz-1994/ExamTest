package thread;

public class test {
    public static void main(String[] args) {
        System.out.println("main方法线程号是："+Thread.currentThread());
        ThreadTest threadTest = new ThreadTest();
        //threadTest.start();
        threadTest.run();
    }
}
