package youzan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringArr = in.nextLine();
        String stringArr2 = stringArr.substring(1,stringArr.length()-1);
        String[] stringArr3 = stringArr2.split(",");
        int[] arr = new int[stringArr3.length];
        for (int i = 0; i < stringArr3.length; i++) {
            arr[i] = Integer.valueOf(stringArr3[i]);
        }
        Set<Integer> indexSet = new HashSet<>();
        int index = 0;
        while (indexSet.size()<=arr.length){
            if (indexSet.contains(index)){
                System.out.println("false");
                break;
            }else {
                indexSet.add(index);
                index = index + arr[index];
                if (index < 0 || index > arr.length-1){
                    System.out.println("true");
                    break;
                }
            }
        }
    }
}
