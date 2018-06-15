package extend;

class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

public class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new Test();
    }
}