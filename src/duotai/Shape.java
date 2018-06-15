package duotai;

public class Shape {
    protected String area;

    Shape(){
        System.out.println("Shape构造方法");
    }

    public void draw(){
        System.out.println("Shape基类draw方法");
    }
    public void erase(){
        System.out.println("Shape基类erase方法");
    }
}
