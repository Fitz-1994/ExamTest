package shunfeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 对称主义者小A定义了一种“双节棍字符串”：形式如同aa…bb…cc…,其中字符a的个数等于字符c的个数，字符b的个数小于他们的个数。例如aaabccc,AACMM。给你一个字符串，输出该字符串的最长双节棍子串，若没有则输出NULL,若有多个则输出最靠前的一个。输入字符串的最长有1000000个字符。
 *
 * 输入
 * aabcccdeeea
 *
 * 输出
 * cccdeee
 *
 *
 * 样例输入
 * AAABCCCDEEE
 * 样例输出
 * AAABCCC
 *
 * 完成度80%
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] inChars = input.toCharArray();
        List<CharsNum> charsNums = new ArrayList<>();
        char currentChar = inChars[0];
        int currentNum = 0;
        for (int i=0;i<inChars.length;i++){
            if (inChars[i] == currentChar){
                currentNum++;
            }else {
                CharsNum charsNum = new CharsNum(currentChar,currentNum);
                charsNums.add(charsNum);
                currentChar = inChars[i];
                currentNum = 1;
            }
        }
        charsNums.add(new CharsNum(currentChar,currentNum));
        int begin;
        int mid;
        int end;
        int resultBegin = -1;
        int resultMid = -1;
        int resultEnd = -1;
        int resultSum = -1;
        for (int i = 0; i < charsNums.size()-2; i++) {
            begin = i;
            mid = i + 1;
            end = i + 2;
            if (charsNums.get(begin).num <= charsNums.get(mid).num){
                continue;
            }
            if (charsNums.get(begin).num != charsNums.get(end).num){
                continue;
            }
            int currentSum = charsNums.get(begin).num + charsNums.get(mid).num + charsNums.get(end).num;
            if (resultBegin == -1 || currentSum > resultSum){
                resultBegin = begin;
                resultMid = mid;
                resultEnd = end;
                resultSum = charsNums.get(resultBegin).num + charsNums.get(resultMid).num + charsNums.get(resultEnd).num;
            }
        }
        String print = "";
        if (resultBegin > -1) {
            for (int i = 0; i < charsNums.get(resultBegin).num; i++) {
                print += charsNums.get(resultBegin).aChar;
            }
            for (int i = 0; i < charsNums.get(resultMid).num; i++) {
                print += charsNums.get(resultMid).aChar;
            }
            for (int i = 0; i < charsNums.get(resultEnd).num; i++) {
                print += charsNums.get(resultEnd).aChar;
            }
            System.out.println(print);
        }else {
            System.out.println("NULL");
        }

    }
}

class CharsNum{
    char aChar;
    int num;

    CharsNum(char aChar, int num){
        this.aChar = aChar;
        this.num = num;
    }
}