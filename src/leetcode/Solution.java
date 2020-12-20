package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
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
        if (isEven) {
            return ((double) (num1 + num2)) / 2;
        } else {
            return (double) num1;
        }
    }

    /**
     * 5.
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //先做空判断
        if (s == null) {
            return null;
        }
        if ("".equals(s)) {
            return s;
        }
        /*
         * 第一种方法，逆转字符串
         * */
        //转换成字符数组
        char[] sToChars = s.toCharArray();
        char[] reversChars = new char[sToChars.length];
        for (int i = sToChars.length; i > 0; i--) {
            reversChars[i - 1] = sToChars[sToChars.length - i];
        }
        //利用两个字符数组找出最长公共子串
        int i1 = 0;
        int length = 1;
        int j1 = 0;
        while (i1 < sToChars.length) {
            if (sToChars[i1] == reversChars[j1]) {
                while (i1 + length < sToChars.length && j1 + length < sToChars.length) {
                    if (sToChars[i1 + length] == reversChars[j1 + length]) {
                        length++;
                    } else {

                    }
                }
            } else if (j1 < sToChars.length) {
                j1++;
            } else {
                i1++;
            }
        }

        return "";
    }

    public boolean isRevers(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 7.
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     *
     * @param x
     * @return
     */
    public int reverse(long x) {
        if (x < -Math.pow(2, 31) || x > (Math.pow(2, 31) - 1)) {
            return 0;
        }
        //获得正负号，和绝对值
        int factor = 1;
        if (x < 0) {
            factor = -1;
        } else if (x == 0) {
            return 0;
        }
        long absX = x * factor;

        char[] xChars = Integer.toString((int) absX).toCharArray();
        List<Character> reCharList = new ArrayList<>();

        int j = 0;
        boolean head = true;
        for (int i = xChars.length - 1; i >= 0; i--) {
            if (head) {
                if (xChars[i] != '0') {
                    reCharList.add(xChars[i]);
                    head = false;
                    j++;
                }
            } else {
                reCharList.add(xChars[i]);
                j++;
            }
        }
        char[] reChars = new char[reCharList.size()];
        for (int i = 0; i < reChars.length; i++) {
            reChars[i] = reCharList.get(i);
        }
        int reAbsX = Integer.valueOf(new String(reChars));
        return reAbsX * factor;
    }

    public static void main(String[] args) {
        int[] intParam = {1, 2};
        int[] intParam2 = {3, 4};
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
        System.out.println(new Solution().reverse(9646324351L));
    }
}
