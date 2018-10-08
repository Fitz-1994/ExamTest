package leetcode;

public class Solution {
    /**
     * 1、两数之和
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        outter:
        for (int i = 0; i < nums.length; i++) {
            inner:
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break outter;
                }
            }
        }
        return result;
    }

    /**
     * 2、两数相加
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode index = null;
        boolean addOne = false;
        while (l1 != null || l2 != null){
            int indexNum = 0;
            if (l1 == null){
                //l1为空，l2不为空
                if (addOne){
                    indexNum = l2.val + 1;
                    addOne = false;
                    if (indexNum > 9){
                        indexNum = indexNum % 10;
                        addOne = true;
                    }
                }else {
                    indexNum = l2.val;
                }
            }else {
                if (l2 == null){
                    //l2为空，l1不为空
                    if (addOne){
                        indexNum = l1.val + 1;
                        addOne = false;
                        if (indexNum > 9){
                            indexNum = indexNum % 10;
                            addOne = true;
                        }
                    }else {
                        indexNum = l1.val;
                    }
                }else {
                    //l1、l2都不为空
                    indexNum = l1.val + l2.val;
                    if (addOne){
                        indexNum++;
                        addOne = false;
                    }
                    if (indexNum > 9){
                        indexNum = indexNum % 10;
                        addOne = true;
                    }
                }
            }
            ListNode temp = new ListNode(indexNum);
            if (head == null){
                head = temp;
                index = temp;
            }else {
                index.next = temp;
                index = temp;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (addOne){
            ListNode temp = new ListNode(1);
            index.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] intParam = {0,4,5,0};
        //int[] result = new Solution().twoSum(intParam,0);
        ListNode l1 = new ListNode(1);
        /*ListNode l11 = new ListNode(8);*/
        /*ListNode l12 = new ListNode(3);*/
        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);/*
        ListNode l22 = new ListNode(4);*/
        l2.next = l21;
        /*l1.next = l11;
        l11.next = l12;
        l21.next = l22;*/
        ListNode listNode = new Solution().addTwoNumbers(l1,l2);
        //System.out.println(result);
    }
}
