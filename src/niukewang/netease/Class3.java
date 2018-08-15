package niukewang.netease;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 完成率30%
 * 链接：https://www.nowcoder.com/discuss/93285
 * 来源：牛客网
 *
 * 给你n个a,m个z组成所有可能的字符串，并将字符串按字典序从小到大排列，输出第k个字符串。
 * 若不存在，输出-1。
 *
 * 输入描述
 * 第一行为三个数，分别为a的个数n,z的个数m,第k个字符串。
 *
 * 输出描述
 * 第k个字符串
 *
 * 示例
 * 输入
 *
 * 1 2 2 6
 * 输出
 *
 * 1 zzaa
 */
public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        char[] chars = new char[n+m];
        for (int i=0;i<n;i++){
            chars[i] = 'a';
        }
        for (int i=0;i<m;i++){
            chars[n+i] = 'z';
        }
        ArrayList<String> result = recursive("",chars);
        if (k>result.size()){
            System.out.println(-1);
        }else {
            System.out.println(result.get(k-1));
        }
    }
    public static ArrayList<String> recursive(String str, char[] leftChars){
        char[] strChars = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        if (leftChars.length == 1){
            char[] resultChars = new char[strChars.length+1];
            for (int i=0;i<strChars.length;i++){
                resultChars[i] = strChars[i];
            }
            resultChars[strChars.length] = leftChars[0];
            String resultString  = new String(resultChars);
            result.add(resultString);
            return result;
        }

        ArrayList<Character> unduplicateList = unDuplicate(leftChars);
        for (Character c : unduplicateList){
            char[] newStrChars = new char[strChars.length+1];
            for (int i=0;i<strChars.length;i++){
                newStrChars[i] = strChars[i];
            }
            newStrChars[strChars.length] = c;
            String newStr = new String(newStrChars);
            char[] newLeftChars = new char[leftChars.length-1];
            boolean deleted = false;
            for (int i=0;i<leftChars.length;i++){
                if (deleted){
                    newLeftChars[i-1] = leftChars[i];
                }else {
                    if (leftChars[i] == c){
                        deleted = true;
                    }else {
                        newLeftChars[i] = leftChars[i];
                    }
                }
            }
            ArrayList<String> nextRound = recursive(newStr,newLeftChars);
            result.addAll(nextRound);
        }
        return result;
    }
    /**
     * 去除重复的字符
     * @param chars
     * @return
     */
    public static ArrayList<Character> unDuplicate(char[] chars){
        ArrayList<Character> unDuplicateList = new ArrayList<>();
        for (char c : chars){
            if (!unDuplicateList.contains(c)){
                unDuplicateList.add(c);
            }
        }
        return unDuplicateList;
    }
}
