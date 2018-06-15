package duotai;

public class Test {
    public static void main(String[] args) {
        //Shape shape = new Shape();
        //Circle circle = new Circle();
        Shape circle = new Circle();

        Test test = new Test();
        //test.doSomething(shape);
        System.out.println("---------------------------");
        test.doSomething(circle);
    }
    public void doSomething(Shape shape){
        shape.draw();
        shape.erase();
    }
}
