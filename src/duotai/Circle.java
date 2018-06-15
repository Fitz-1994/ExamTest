package duotai;

public class Circle extends Shape{
    Circle(){
        System.out.println("Circle构造方法");
    }
    @Override
    public void draw() {
        System.out.println("Circle类draw方法");
    }

    @Override
    public void erase() {
        System.out.println("Circle类erase方法");
    }

    public void circleMethod(){
        System.out.println("Circle类型的特有方法");
    }
}
