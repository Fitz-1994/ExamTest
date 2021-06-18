package leetcode;

import java.util.*;

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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        int sum;
        boolean addOne = false;
        if (l1.val == 0) {
            head = l2;
        } else if (l2.val == 0) {
            head = l1;
        } else {
            sum = l1.val + l2.val;
            if (sum < 10) {
                head = new ListNode(sum);
            } else {
                head = new ListNode(sum % 10);
                addOne = true;
            }
        }
        ListNode index = head;
        l1 = l1.next;
        l2 = l2.next;

        while (true) {
            //没有+1
            if (!addOne) {
                //判断是否有一个数已经算完
                if (l1 == null) {
                    index.next = l2;
                    break;
                }
                if (l2 == null) {
                    index.next = l1;
                    break;
                }
                if (l1.val == 0) {
                    index.next = l2;
                } else if (l2.val == 0) {
                    index.next = l1;
                } else {
                    sum = l1.val + l2.val;
                    if (sum < 10) {
                        index.next = new ListNode(sum);
                    } else {
                        index.next = new ListNode(sum % 10);
                        addOne = true;
                    }
                }
                l1 = l1.next;
                l2 = l2.next;
            } else {
                //判断是否有一个数已经算完
                if (l1 == null && l2 == null) {
                    index.next = new ListNode(1);
                    break;
                } else if (l1 == null) {
                    sum = l2.val + 1;
                    if (sum < 10) {
                        index.next = new ListNode(sum, l2.next);
                        break;
                    } else {
                        index.next = new ListNode(0);
                        l2 = l2.next;
                    }
                } else if (l2 == null) {
                    sum = l1.val + 1;
                    if (sum < 10) {
                        index.next = new ListNode(sum, l1.next);
                        break;
                    } else {
                        index.next = new ListNode(0);
                        l1 = l1.next;
                    }
                } else {
                    // 有+1 且两个都不是null
                    sum = l1.val + l2.val + 1;
                    if (sum < 10) {
                        index.next = new ListNode(sum);
                        addOne = false;
                    } else {
                        index.next = new ListNode(sum % 10);
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            index = index.next;
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
        int totalLength = nums1.length + nums2.length;
        boolean isEven = (totalLength % 2 == 0);
        int mid1 = (totalLength / 2) - 1;
        int mid2 = mid1 + 1;

        int num1 = 0;
        int num2 = 0;

        int index1 = 0;
        int index2 = 0;

        int currentNum;

        for (int i = 0; i <= mid2; i++) {
            if (index1 == nums1.length) {
                //数组1已经比较完毕
                currentNum = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                //数组2已经比较完毕
                currentNum = nums1[index1];
                index1++;
            } else {
                //两个数组都没有比较完毕
                if (nums1[index1] <= nums2[index2]) {
                    currentNum = nums1[index1];
                    index1++;
                } else {
                    currentNum = nums2[index2];
                    index2++;
                }
            }
            if (isEven && i == mid1) {
                num1 = currentNum;
            } else if (i == mid2) {
                num2 = currentNum;
            }
        }
        if (isEven) {
            return (num1 + num2) / 2.0;
        } else {
            return num2;
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
        //DP解法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int resultBeg = 0;
        int resultEnd = 0;
        int maxLen = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (maxLen < 2) {
                            maxLen = 2;
                            resultBeg = i;
                            resultEnd = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (maxLen < j - i + 1) {
                            maxLen = j - i + 1;
                            resultBeg = i;
                            resultEnd = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return s.substring(resultBeg, resultEnd + 1);
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


    /**
     * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
     * <p>
     * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
     * <p>
     * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
     * <p>
     * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
     * <p>
     * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
     * <p>
     * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-refueling-stops
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int maxRoad = startFuel;
        int minTime = 0;
        for (int i = 0; i < stations.length; i++) {
            if (maxRoad >= stations[i][0]) {
                pq.offer(stations[i][1]);
            } else {
                while (pq.size() != 0) {
                    maxRoad += pq.poll();
                    minTime++;
                    if (maxRoad >= target) {
                        return minTime;
                    }
                    if (maxRoad >= stations[i][0]) {
                        pq.offer(stations[i][1]);
                        break;
                    }
                }
                if (maxRoad < stations[i][0]) {
                    return -1;
                }
            }
        }
        if (maxRoad >= target) {
            return minTime;
        } else {
            while (pq.size() != 0) {
                int maxFuel = pq.poll();
                maxRoad += maxFuel;
                minTime++;
                if (maxRoad >= target) {
                    return minTime;
                }
            }
            return -1;
        }
    }

    public int minRefuelStops_fail(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            return startFuel < target ? -1 : 0;
        }
        return oneStation(startFuel, target, -1, stations, 0);
    }

    private int oneStation(int currentFule, int remain, int index, int[][] stations, int minTime) {
        //最后一站
        if (index == stations.length - 1) {
            //不用加油直接到终点
            if (currentFule >= remain) {
                return minTime;
            }
            currentFule = currentFule + stations[index][1];
            return currentFule >= remain ? minTime + 1 : -1;
        }
        //起点
        if (index == -1) {
            //不用加油直接到终点
            if (currentFule >= remain) {
                return minTime;
            }
            //到不了第一个加油站
            if (currentFule < stations[0][0]) {
                return -1;
            }
            return oneStation(currentFule - stations[0][0], remain - stations[0][0], 0, stations, 0);
        }
        //中间
        if (currentFule >= remain) {
            return minTime;
        }
        //不加油
        int gapToNext = getGap(stations, index + 1);
        //不加油到不了下一站，一定得加油
        if (currentFule < gapToNext) {
            currentFule = currentFule + stations[index][1] - gapToNext;
            //加了油也到不了下一站
            if (currentFule < 0) {
                return -1;
            }
            remain = remain - gapToNext;
            index++;
            minTime++;
            return oneStation(currentFule, remain, index, stations, minTime);
        }
        //不加油能到下一站，可以选择不加油
        int notRefule = oneStation(currentFule - gapToNext, remain - gapToNext, index + 1, stations, minTime);
        int refule = oneStation(currentFule + stations[index][1] - gapToNext, remain - gapToNext, index + 1, stations, minTime + 1);
        return getMin(notRefule, refule);
    }

    /**
     * 获取当前加油站和上一个加油站之间的距离
     *
     * @param stations
     * @param index
     * @return
     */
    private int getGap(int[][] stations, int index) {
        if (index == 0) {
            return stations[0][0];
        }
        return stations[index][0] - stations[index - 1][0];
    }

    private int getMin(int notRefule, int refule) {
        if (notRefule == refule) {
            return notRefule;
        }
        if (notRefule == -1) {
            return refule;
        }
        if (refule == -1) {
            return notRefule;
        }
        return Math.min(notRefule, refule);
    }

    /**
     * 剑指 Offer 63. 股票的最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int max = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int gap = price - minPrice;
            if (gap > max) {
                max = gap;
            }
        }
        return max;
    }

    /**
     * 10. 正则表达式匹配
     * @param s
     * @param p
     * @return
     */
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0){
//            return s.length()==0;
//        }
//        if (p.length() == 1){
//            if (".".equals(p)){
//                return s.length() == 1;
//            }else {
//                return p.equals(s);
//            }
//        }
//        // dp[i][j]表示 s的第i位及之前与p的第j位及之前的匹配情况
//        boolean[][] dp = new boolean[s.length()][p.length()];
//        char[] pChars = p.toCharArray();
//        char[] sChars = s.toCharArray();
//        int i = 0;
//        int j = 0;
//        for (; i < pChars.length; i++) {
//            if (pChars[i] != '.' && pChars[i] != '*'){
//                dp[]
//            }
//        }
//        return dp[s.length()-1][p.length()-1];
//    }


    /**
     * 11. 盛最多水的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int tail = height.length - 1;
        int headLast = 0;
        int tailLast = 0;
        head:
        for (int head = 0; head < tail; head++) {
            if (height[head] <= headLast) {
                continue;
            }
            for (; head < tail; tail--) {
                if (height[tail] <= tailLast) {
                    continue;
                }
                int area = getArea(height, head, tail);
                if (area > maxArea) {
                    maxArea = area;
                }
                if (height[head] < height[tail]) {
                    headLast = height[head];
                    continue head;
                } else {
                    tailLast = height[tail];
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * Math.abs(j - i);
    }

    public static void main(String[] args) {
//        int[] intParam = {1, 3};
//        int[] intParam2 = {2};
        //int[] result = new Solution().twoSum(intParam,0);
//        ListNode l1 = new ListNode(1);
//        ListNode l11 = new ListNode(8);
//        ListNode l12 = new ListNode(3);
//        ListNode l2 = new ListNode(9);
//        ListNode l21 = new ListNode(9);
//        ListNode l22 = new ListNode(4);
//        l2.next = l21;
//        l1.next = l11;
//        l11.next = l12;
//        l21.next = l22;
        //ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        //System.out.println(new Solution().findMedianSortedArrays(intParam, intParam2));
        //System.out.println(new Solution().reverse(9646324351L));
        //int [][] stops = {{10,60},{20,30},{30,30},{60,40}};
//        int[][] stops = {{25, 25}, {50, 50}};
        //int [][] stops = {};
//        System.out.println(new Solution().minRefuelStops(100, 50, stops));
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
