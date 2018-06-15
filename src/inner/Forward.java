package inner;

public class Forward {
    private String name;

    Forward(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i=0;i<10;i++){
            sequence.add(new Forward("forward"+i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
