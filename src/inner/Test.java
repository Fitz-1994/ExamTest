package inner;

public class Test {
    private String name;

    private void priMethod(){
        System.out.println("Outer Class private Method");
    }

    class TestInner {
        private String inner = "inner Class";
        public void changeName(String name){
            Test.this.name = name;
            priMethod();
        }
    }
    public void innerClassString(){
        TestInner testInner = new TestInner();
        System.out.println(testInner.inner);
    }

    public TestInner getInner(){
        return new TestInner();
    }
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("name before change is "+test.name);
        TestInner testInner = test.new TestInner();
        testInner.changeName("forward");
        System.out.println("name after change is "+test.name);
        test.innerClassString();
    }
}
