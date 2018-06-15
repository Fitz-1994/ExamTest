import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    static final int INDEX_1 = 1;
    static final int INDEX_2 = 1;

    public static void main(String[] args) {
        fibonacci(9);
    }
    static void fibonacci(int num){

        List<Integer> fibnacci = new ArrayList<>();
        //初始化最初的两个值
        fibnacci.add(INDEX_1);
        fibnacci.add(INDEX_2);
        if (num == 1){
            System.out.println("1");
        }else if (num == 2){
            System.out.println("1 1");
        }else {
            //大于2的情况
            System.out.print("1 1");
            for (int i = 3;i<=num;i++){
                fibnacci.add(fibnacci.get(i-3)+fibnacci.get(i-2));
                System.out.print(" " + fibnacci.get(fibnacci.size()-1));
            }
        }
    }
}
