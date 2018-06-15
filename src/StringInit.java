public class StringInit {
    String init = "init";
    String cons;

    StringInit(){
        cons = "cons";
    }

    public static void main(String[] args) {
        StringInit stringInit = new StringInit();
        StringInit stringInit1 = new StringInit();
        System.out.println(stringInit.cons == stringInit1.cons);
        System.out.println(stringInit.init == stringInit1.init);
        System.out.println("init :"+stringInit.init);
        System.out.println("cons :"+stringInit.cons);
    }
}
