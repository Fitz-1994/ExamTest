package leetcode;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * 3、无重复字符的最长子串
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。

     示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 无重复字符的最长子串是 "b"，其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        int max = 0;
        char[] strArray = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        while (end < strArray.length){
            if (charSet.contains(strArray[end])){
                //找出与end相同的字符的位置
                for (int i = begin; i < end; i++) {
                    if (strArray[i] == strArray[end]){
                        begin = i+1;
                        break;
                    }else {
                        charSet.remove(strArray[i]);
                    }
                }
                end++;
            }else {
                charSet.add(strArray[end]);
                end++;
                if (max < end-begin){
                    max = end - begin;
                }
            }
        }
        return max;
    }

    /**
     * 4、两个排序数组的中位数
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
     *
     * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
     *
     * 你可以假设 nums1 和 nums2 不同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 中位数是 (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int totalLength = nums1.length+nums2.length;
        //是否是偶数，如果是isEven = true，如果不是isEven = false
        boolean isEven = (totalLength%2 == 0);
        int num1 = 0;
        int num2 = 0;
        int[] integerArray = new int[totalLength];
        for (int i = 0; i < totalLength; i++) {
            if (index1 == nums1.length){
                //数组1已经比较完毕
                integerArray[i] = nums2[index2];
                index2++;
            }else if (index2 == nums2.length){
                //数组2已经比较完毕
                integerArray[i] = nums1[index1];
                index1++;
            }else {
                //两个数组都没有比较完毕
                if (nums1[index1] <= nums2[index2]){
                    integerArray[i] = nums1[index1];
                    index1++;
                }else {
                    integerArray[i] = nums2[index2];
                    index2++;
                }
            }
            if (isEven){
                if (i == totalLength/2-1){
                    num1 = integerArray[i];
                }else if (i == totalLength/2){
                    num2 = integerArray[i];
                    break;
                }
            }else {
                if (i == totalLength/2) {
                    num1 = integerArray[i];
                    break;
                }
            }
        }
        if (isEven){
            return ((double)(num1+num2))/2;
        }else {
            return (double)num1;
        }
    }

    public static void main(String[] args) {
        int[] intParam = {1,2};
        int[] intParam2 = {3,4};
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
        //ListNode listNode = new Solution().addTwoNumbers(l1,l2);
        System.out.println(new Solution().findMedianSortedArrays(intParam,intParam2));
    }
}
