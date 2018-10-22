package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strArray = new String[n];
        for (int i=0;i<n;i++){
            strArray[i] = in.next();
        }
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(change(strArray[i]));
        }
    }

    public static String change(String str){
        char[] charArr = str.toCharArray();
        List<Character> resList = new ArrayList<>();
        boolean series = false;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i]>= 'A' && charArr[i] <='Z'){
                if (!series){
                    if (resList.size() != 0) {
                        resList.add('_');
                    }
                    series = true;
                }
                if (i+2 < charArr.length && charArr[i+2] >'Z'){
                    series = false;
                }

                resList.add(Character.toLowerCase(charArr[i]));
            }else {
                if (series){
                    series = false;
                }
                resList.add(charArr[i]);
            }
        }
        char[] resArray = new char[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArray[i] = resList.get(i);
        }
        String res = new String(resArray);
        return res;
    }
}
