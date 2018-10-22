package beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[] strArr = line.toCharArray();
        List<String> nums = new ArrayList<>();
        List<Character> flags = new ArrayList<>();
        int lastIndex = 0;
        for (int i=0;i<strArr.length;i++){
            if (i == 0 && strArr[i] =='-'){
                nums.add("0");
                flags.add('-');
                continue;
            }
            if (strArr[i] =='+' || strArr[i] == '-' ){
                flags.add(strArr[i]);
                nums.add(line.substring(lastIndex,i));
                lastIndex = i+1;
            }
        }
        nums.add(line.substring(lastIndex));
        /*System.out.println(nums);
        System.out.println(flags);*/
        int index = 0;
        int sum = 0;
        while (index < nums.size()){
            if ("0x".equals(nums.get(index).substring(0,2))){
                if (index == 0 ||  flags.get(index-1) .equals('+')) {
                    sum += Integer.parseInt(nums.get(index).substring(2), 16);
                }else {
                    sum -= Integer.parseInt(nums.get(index).substring(2), 16);
                }
            }else if ("0".equals(nums.get(index).substring(0,1))){
                if (index == 0 || flags.get(index-1).equals('+')) {
                    sum += Integer.parseInt(nums.get(index).substring(1),8);
                }else {
                    sum -= Integer.parseInt(nums.get(index).substring(1),8);
                }

            }else {
                if (index == 0 ||flags.get(index-1).equals('+')) {
                    sum += Integer.valueOf(nums.get(index));
                }else {
                    sum -= Integer.valueOf(nums.get(index));
                }
            }
            index++;
        }
        System.out.println(sum);
    }
}
