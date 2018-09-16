package niukewang.zhaoshangbank.xinyongka;

import java.util.Scanner;

public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isGoodNum(int num){
        char[] numChars = Integer.toString(num).toCharArray();
        boolean result = true;
        boolean contain2569 = false;
        for (char c : numChars){
            if (c == '3' || c == '4' || c == '7'){
                result = false;
                break;
            }else {
                if (c == '2' || c =='5' || c == '6' || c == '9'){
                    contain2569 = true;
                }
            }
        }
        if (!result){
            return false;
        }else {
            if (contain2569){
                return true;
            }else {
                return false;
            }
        }
    }
}
