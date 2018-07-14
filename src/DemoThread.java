
class DemoThread extends Thread {
    public static void main(String args[]) {
        DemoThread threadOne = new DemoThread();
        DemoThread threadTwo = new DemoThread();
        threadOne.start();
        System.out.println("thread one.");
        threadTwo.start();
        System.out.print("thread two.");
    }
    @Override
    public void run() {
        System.out.print("Thread.");
    }
}