package dongfangcaifu;

import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringArr = in.nextLine();
        String[] strings = stringArr.split(",");
        int[] arr = new int[strings.length];
        for (int i=0;i<strings.length;i++){
            arr[i] = Integer.valueOf(strings[i]);
        }
        System.out.println(jump(arr,0));

    }

    public static int jump(int[] arr, int index){
        int target = arr.length - index -1;
        if (target <= arr[index]){
            return 1;
        }else {
            int leastStep = -1;
            for (int i = 1; i <= arr[index]; i++) {
                int steps = jump(arr,index+i) +1;
                if (leastStep == -1){
                    leastStep = steps;
                }else if (steps < leastStep){
                    leastStep = steps;
                }
            }
            return leastStep;
        }
    }

}
