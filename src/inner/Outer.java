package inner;

public class Outer {
    private String name;
    Outer(String name){
        this.name = name;
    }
    class Inner{
        String innerLable;
        Inner(String innerLable){
            this.innerLable = innerLable;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public Inner getInnerObject(){
        return new Inner("forward");
    }

    public static void main(String[] args) {
        Outer outer = new Outer("Outer Name");
        Outer.Inner inner = outer.getInnerObject();
        //System.out.println(inner.innerLable);
        System.out.println(inner);
    }
}
