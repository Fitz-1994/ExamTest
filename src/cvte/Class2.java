package cvte;

import java.util.ArrayList;
import java.util.List;

public class Class2 {
    public static void main(String[] args) {
        System.out.println(count(10));
    }
    public static int count(int number){
        //求出比number/3小的所有素数
        List<Integer> list = new ArrayList<>();
        boolean isPrime;
        for (int i = 2; i <= number/3; i++) {
            if (isSushu(i)){
                list.add(i);
            }
        }
        int sum = 0;
        for (int i=0;i<list.size()-1;i++){
            for (int j=i+1;j<list.size();j++){
                if (isSushu(number-list.get(i)-list.get(j))){
                    sum++;
                }
            }
        }
        return sum*6;
    }
    //判断一个数时候是素数
    private static boolean isSushu(int num){
        boolean flag = true;
        if(num <2){
            return false;
        }
        for(int i = 2;i<num;i++){
            if(num%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
