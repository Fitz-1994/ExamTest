package niukewang;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author forward
 */
public class Solution {
    /**
     * 1
     * 题目：
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 该题已通过，采用最简单的遍历二维数组的方法
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean contains = false;
        outter:
        for (int i[] :array){
            for (int j:i){
                if (j == target){
                    contains = true;
                    break outter;
                }
            }
        }
        return contains;
    }

    /**
     * 2
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     *
     * 该题已通过，调用String api中的replaceAll方法即可实现这个功能，还有一种是将String转换成char数组，来替换
     */
    public static String replaceSpace(StringBuffer str) {
        String string = new String(str);
        /*char[] ch = string.toCharArray();*/
        String returnString = string.replaceAll(" ","%20");
        return returnString;
    }

    /**
     * 3
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*
        * 方法1：
        * 通过数组保存所有的值，再逆向输出
        * 该方法可以实现功能，但是存在内存溢出或超时
        * */
        /*int[] normList = new int[1];
        int i = 0;
        while (listNode != null ){
            if (normList.length >= i){
                normList = new int[normList.length+1];
            }
            normList[i] = listNode.val;
            i++;
            listNode = listNode.next;
        }
        ArrayList<Integer> reverseList = new ArrayList<>();
        if (i > 0) {
            for (int j = i-1; j >= 0; j--) {
                reverseList.add(normList[j]);
            }
        }
        System.out.println(reverseList);
        return reverseList;*/

        /*
        * 方法2通过用栈的方式通过全部测试用例
        * */
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        System.out.println(list);
        return list;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        //题目2的测试代码
        /*StringBuffer str = new StringBuffer("helloworld ");
        String string = replaceSpace(str);
        System.out.println(string);*/

        //题目3的测试代码
        //ListNode listNode = new ListNode(1);
        ArrayList<Integer> list = printListFromTailToHead(null);

    }
}
