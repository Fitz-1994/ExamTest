package dongfangcaifu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringArr = in.nextLine();
        String[] strings = stringArr.split(",");
        int[] arr = new int[strings.length];
        for (int i=0;i<strings.length;i++){
            arr[i] = Integer.valueOf(strings[i]);
        }
        Set<Integer> arrSet = new HashSet<>();
        for (int i : arr){
            if (arrSet.contains(i)){
                System.out.println(i);
                break;
            }else {
                arrSet.add(i);
            }
        }
    }
}
