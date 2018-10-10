package cvte;

import java.util.LinkedList;
import java.util.List;

public class Class1 {
    public static void main(String[] args) {
        findRepeatNumber("YJL12eD90Cyd");
    }
    public static int findRepeatNumber(String code){
        String upperCode = code.toUpperCase();
        char[] upperCodeArr = upperCode.toCharArray();
        List<Character> list = new LinkedList<>();
        for (char c:upperCodeArr){
            list.add(c);
        }
        int index = 0;
        int sum = 0;
        while (index < list.size()){
            boolean repeat = false;
            int innerIndex = index + 1;
            while (innerIndex < list.size()){
                if (list.get(innerIndex).equals(list.get(index))){
                    repeat = true;
                    list.remove(innerIndex);
                }else {
                    innerIndex++;
                }
            }
            if (repeat){
                sum++;
            }
            index++;
        }
        return sum;
    }
}
