package niukewang.zhaoshangbank.xinyongka;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        //获取输入信息
        Scanner in = new Scanner(System.in);
        String children = in.nextLine();
        String candy = in.nextLine();
        List<Integer> childrenList = splitFromInput(children);
        List<Integer> candyList = splitFromInput(candy);
        //分发糖果过程
        int satisfiChildren = 0;
        int maxChild = 0;
        int maxCandy = 0;
        /*boolean childResearch = true;*/
        boolean candyResearch = true;
        while (childrenList.size() > 0 && candyList.size() > 0){
            //找出胃口最大的孩子和尺寸最大的糖
            /*if (childResearch) {*/
                for (int i = 0; i < childrenList.size(); i++) {
                    if (childrenList.get(i) > childrenList.get(maxChild)) {
                        maxChild = i;
                    }
                }
            /*    childResearch = false;
            }*/
            if (candyResearch) {
                for (int i = 0; i < candyList.size(); i++) {
                    if (candyList.get(i) > candyList.get(maxCandy)) {
                        maxCandy = i;
                    }
                }
                candyResearch = false;
            }
            //最大的糖果可以满足胃口最大的孩子
            if (candyList.get(maxCandy) >= childrenList.get(maxChild)){
                satisfiChildren++;

                /*childResearch = true;*/
                candyList.remove(maxCandy);
                maxCandy = 0;
                candyResearch = true;
            }
            childrenList.remove(maxChild);
            maxChild = 0;
        }
        System.out.println(satisfiChildren);
    }

    public static List<Integer> splitFromInput(String input){
        List<Integer> result = new LinkedList<>();
        String[] splited =  input.split(" ");
        for (String s : splited){
            if (!"".equals(s)) {
                result.add(Integer.valueOf(s));
            }
        }
        return result;
    }
}
