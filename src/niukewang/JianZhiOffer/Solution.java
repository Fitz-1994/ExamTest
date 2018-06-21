package niukewang.JianZhiOffer;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * 链表数据结构
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 4：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     * 该题已通过，利用递归的思想来解决
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = -1;
        for (int i = 0;i<in.length;i++){
            if (in[i] == root.val){
                rootIndex = i;
            }
        }
        int[] leftIn = new int[rootIndex];
        int[] rightIn = new int[in.length-rootIndex-1];
        for (int left=0;left<rootIndex;left++){
            leftIn[left] = in[left];
        }
        for (int right=rootIndex+1;right<in.length;right++){
            rightIn[right-(rootIndex+1)] = in[right];
        }
        int[] leftPre = getNextPre(leftIn,pre);
        int[] rightPre = getNextPre(rightIn,pre);

        if (leftIn.length==0){
            root.left = null;
        }else {
            root.left = reConstructBinaryTree(leftPre,leftIn);
        }
        if (rightIn.length ==0){
            root.right = null;
        }else {
            root.right = reConstructBinaryTree(rightPre,rightIn);
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 通过下一级的中序遍历数组和上一级的前序遍历数组，得到下一级的前序遍历数组
     * @param nextIn
     * @param pre
     * @return
     */
    public int[] getNextPre(int[] nextIn,int[] pre){
        int[] nextPre = new int[nextIn.length];
        int index = 0;
        for (int preNum : pre){
            for (int nextInNum : nextIn){
                if (preNum == nextInNum){
                    nextPre[index] = nextInNum;
                    index++;
                    break;
                }
            }
        }
        return nextPre;
    }

    /**
     * 第6题：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     * 不是很明白这个题目的精髓，因为一个数组，无论有没有旋转，最小值是一样的，所以这个题目就是一个求数组最小值的算法。
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int min = array[0];
        for (int arrNum : array){
            if (arrNum < min){
                min = arrNum;
            }
        }
        return min;
    }

    /**
     * 第7题
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     * n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        List<Integer> fibnacci = new ArrayList<>();
        //初始化最初的两个值
        fibnacci.add(1);
        fibnacci.add(1);
        int fibnacciN = 0;
        if (n == 1){
            fibnacciN = 1;
        }else if (n == 2){
            fibnacciN = 1;
        }else {
            //大于2的情况
            for (int i = 3;i<=n;i++){
                fibnacci.add(fibnacci.get(i-3)+fibnacci.get(i-2));
                fibnacciN = fibnacci.get(fibnacci.size()-1);
            }
        }
        return fibnacciN;
    }

    /**
     * 题8
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     * 已通过
     * 解题思路：递归
     * 1级的时候只有一次，2级的时候只有两次
     * 青蛙的第一步有两种情况，跳1级和跳2级，那么n级台阶的跳法就可以分解为 n-1级数量+n-2级的数量
     */
    public int jumpFloor(int target) {
        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            return jumpFloor(target-1)+jumpFloor(target-2);
        }
    }

    /**
     * 题9：变态青蛙跳
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 已通过
     * 解题思路，递归
     * @param target
     * @return
     */
    public int jumpFloor2(int target) {
        if (target == 0){
            return 1;
        }else if (target == 1){
            return 1;
        }else {
            int sum = 0;
            for (int i=0;i<target;i++){
                sum += jumpFloor2(i);
            }
            return sum;
        }
    }

    /**
     * 题10：矩形覆盖
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 分析题目可得，这个题实际上就是普通青蛙跳
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else if (target == 0){
            return 0;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }

    /**
     * 题11：
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 已完成，使用Integer的toBinaryString转换整形为二进制字符串
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        String binary = Integer.toBinaryString(n);
        char[] binaryChar = binary.toCharArray();
        int count = 0;
        for (char bit : binaryChar){
            if (bit == '1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 题12：
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 已通过，分两种情况，指数为正和指数为负
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent>=0) {
            double result = 1.0;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }else {
            double reBase = 1.0/base;
            int reExp = -exponent;
            double result = reBase;
            for (int i = 1; i < reExp; i++) {
                result *= reBase;
            }
            return result;
        }
    }

    /**
     * 题13：
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 已解决
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array.length != 0){
            int[] tempArr = new int[array.length];
            //遍历两遍数组,第一遍奇数、第二遍偶数
            int index = 0;
            for (int num: array){
                if (num % 2 == 1){
                    tempArr[index] = num;
                    index++;
                }
            }
            for (int num:array){
                if (num % 2 == 0){
                    tempArr[index] = num;
                    index++;
                }
            }
            for (int i=0;i<tempArr.length;i++){
                array[i] = tempArr[i];
            }
        }
    }

    /**
     * 题14
     * 输入一个链表，输出该链表中倒数第k个结点。
     * 已完成
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;
        //将所有的链表节点放入一个顺序表中
        while (node != null){
            listNodes.add(node);
            node = node.next;
        }
        ListNode listNode = null;
        //分为两种情况来区分,如果包含倒数第k个节点，则返回这个节点，如果不包含，则返回空
        if (listNodes.size() >= k && k != 0){
            listNode = listNodes.get(listNodes.size()-k);
        }
        return listNode;
    }


    public static void main(String[] args) {
        //题目2的测试代码
        /*StringBuffer str = new StringBuffer("helloworld ");
        String string = replaceSpace(str);
        System.out.println(string);*/

        //题目3的测试代码
        //ListNode listNode = new ListNode(1);
        //ArrayList<Integer> list = printListFromTailToHead(null);
        Solution solution = new Solution();
        //System.out.println(solution.Power(2,-3));

    }
}
