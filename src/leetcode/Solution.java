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
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target-nums[i]);
            if (index == null){
                map.put(nums[i],i);
            }else {
                return new int[]{i,index};
            }
        }
        return new int[0];
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
        return addDiGui(l1,l2,0);
    }

    private ListNode addDiGui(ListNode l1,ListNode l2,int add){
        if (l1 == null && l2 == null){
            if (add == 0){
                return null;
            }else {
                return new ListNode(1);
            }
        }
        if (l2 == null){
            l2 = l1;
            l1 = null;
        }
        if (l1 == null){
            int sum = l2.val + add;
            if (sum < 10){
                l2.val = sum;
                return l2;
            }else {
                l2.val = sum % 10;
                l2.next = addDiGui(null,l2.next,1);
                return l2;
            }
        }

        int sum = l1.val+l2.val+add;
        if (sum < 10){
            l1.val = sum;
            add = 0;
        }else {
            l1.val = sum%10;
            add = 1;
        }
        l1.next = addDiGui(l1.next,l2.next,add);
        return l1;
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
        Set<Character> set = new HashSet<>();
        int begin = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()){
            char endC = s.charAt(end);
            if (!set.contains(endC)){
                set.add(endC);
                max = Math.max(max,end-begin+1);
                end++;
            }else {
                set.remove(s.charAt(begin));
                begin++;
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
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        char[] chars = s.toCharArray();
        int max = 1;
        int begin = 0;
        int end = 0;
        for (int len = 1; len <= length; len++) {
            int lastIndex = length - len;
            for (int i = 0; i <= lastIndex; i++) {
                if (len == 1){
                    p[i][i] = true;
                    continue;
                }
                int j = i+len-1;
                if (len == 2){
                    p[i][j] = chars[i]==chars[j];
                    if (p[i][j] && max < 2){
                        max = 2;
                        begin = i;
                        end = j;
                    }
                    continue;
                }
                p[i][j] = p[i+1][j-1] && chars[i]==chars[j];
                if (p[i][j] && max<len){
                    max = len;
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin,end+1);
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
                    break;
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

    /**
     * 461. 汉明距离
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        char[] xBin = Integer.toBinaryString(x).toCharArray();
        char[] yBin = Integer.toBinaryString(y).toCharArray();
        int maxLength = Integer.max(xBin.length, yBin.length);
        int distance = 0;
        for (int i = 0; i < maxLength; i++) {
            if (xBin.length - 1 - i < 0) {
                if (yBin[yBin.length - 1 - i] != '0') {
                    distance++;
                }
                continue;
            }
            if (yBin.length - 1 - i < 0) {
                if (xBin[xBin.length - 1 - i] != '0') {
                    distance++;
                }
                continue;
            }
            if (xBin[xBin.length - 1 - i] != yBin[yBin.length - 1 - i]) {
                distance++;
            }
        }
        return distance;
    }

//    public int[] findTop100(int[] nums){
//        int[] top100 = new int[100];
//        int min = nums[0];
//        int minIndex = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i<100){
//                top100[i] = nums[i];
//                if (nums[i]<min){
//                    min = nums[i];
//                    minIndex = i;
//                }
//            }else {
//                //最小值
//
//
//            }
//
//
//        }
//
//
//    }

    class Node {
        String val;
        Node next;

        Node() {
        }

        Node(String val) {
            this.val = val;
        }

        Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(val, node.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public boolean isCircle(Node node) {
        Node node1 = node;
        Node node2 = node;

        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
            if (node2 != null) {
                node2 = node2.next;
            } else {
                return false;
            }
            if (node1.equals(node2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContinuity(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int zeroNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        if (zeroNum == nums.length) {
            return true;
        }
        return max - min < nums.length;
    }

    /**
     * 15. 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int k = nums.length-1;
            for (int j = i+1; j < k; j++) {
                if (j>i+1 && nums[j-1] == nums[j]){
                    continue;
                }
                int target = -(nums[i]+nums[j]);
                while (j < k && nums[k] > target){
                    k--;
                }
                if (j >= k){
                    break;
                }
                if (nums[k] == target){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return result;
    }

//    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
//        put('2', "abc");
//        put('3', "def");
//        put('4', "ghi");
//        put('5', "jkl");
//        put('6', "mno");
//        put('7', "pqrs");
//        put('8', "tuv");
//        put('9', "wxyz");
//    }};
//    public List<String> letterCombinations(String digits) {
//
//        if (digits.length() == 0 ){
//            return new ArrayList<>();
//        }
//
//        List<String> result = new LinkedList<>();
//        digui(digits,0,new StringBuilder(),result);
//        return result;
//    }
//
//    public void digui(String digits,int index,StringBuilder stringBuilder,List<String> result){
//        if (index == digits.length()){
//            result.add(stringBuilder.toString());
//            return;
//        }
//
//        String letter = phoneMap.get(digits.charAt(index));
//        for (char c : letter.toCharArray()) {
//            stringBuilder.append(c);
//            digui(digits,index+1,stringBuilder,result);
//            stringBuilder.deleteCharAt(index);
//        }
//
//    }
    public static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }
        letterBacktrace(digits,0,result,new StringBuilder());
        return result;
    }
    private void letterBacktrace(String digits, int index, List<String> result, StringBuilder sb){
        char c = digits.charAt(index);
        String letters = phoneMap.get(c);

        if (index == digits.length()-1){
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                result.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            }
        }else {
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                letterBacktrace(digits,index+1,result,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = 0;
//        ListNode i = head;
//        while (i != null){
//            length++;
//            i = i.next;
//        }
//
//        int removeIndex = length - n;
//        ListNode j = head;
//        ListNode jPre = null;
//        int k = 0;
//        while (k != removeIndex){
//            jPre = j;
//            j = j.next;
//            k++;
//        }
//        if (jPre != null){
//            jPre.next = j.next;
//            return head;
//        }
//        return head.next;
        List<ListNode> nodeList = new ArrayList<>(30);
        ListNode i = head;
        while (i != null){
            nodeList.add(i);
            i = i.next;
        }
        if (n == nodeList.size()){
            return head.next;
        }
        int remodeIndex = nodeList.size() - n;
        nodeList.get(remodeIndex-1).next = nodeList.get(remodeIndex).next;
        return head;
    }

    public boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sArr) {
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     * 23. 合并K个升序链表
     * 分治法 + 合并两个数组的的方法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 31. 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 倒序找到实际上需要重新排列的起始位置 i
        int i = nums.length - 2;
        boolean isMax = true;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]){
                isMax = false;
                break;
            }
        }
        // 最大组合 重新排序成最小组合 返回
        if (isMax){
            Arrays.sort(nums);
            return;
        }

        // default is max gap
        int minGap = 100;
        int nextNumIndex = -1;

        //找到第i位后的 大于 num[i]的最小数
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i] && (nums[j]-nums[i]) < minGap){
                minGap = nums[j]-nums[i];
                nextNumIndex = j;
            }
        }

        //交换第i位和第nextNumIndex位
        int temp;
        temp = nums[i];
        nums[i] = nums[nextNumIndex];
        nums[nextNumIndex] = temp;

        Arrays.sort(nums,i+1,nums.length);
        System.out.println(nums);
    }

    /**
     * 32. 最长有效括号
     *  TODO 未完成
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Character> quotaStack = new Stack<>();
        char[] chars = s.toCharArray();
        char left = '(';
        char right = ')';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == left){
                quotaStack.push(left);
                builder.append(left);
            }
        }

        return 0;
    }

    /**
     * 33. 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        /*
        * 思路：
        * 先比较nums[0] 与target的大小 ，确定target值在nums旋转点的前半段还是后半段
        * 然后用二分查找找到旋转点
        * 然后在target所在的半段数组中进行二分查找
        * */
        if (nums.length == 1){
            return target == nums[0]?0:-1;
        }
        //先判断没有旋转的情况
        int start = 0;
        int end = nums.length-1;
        int mid = -1;
        if (nums[nums.length-1] < nums[0]){
            boolean potision;
            if (target >= nums[0] ){
                //前半段
                potision = true;
            }else {
                //后半段
                potision = false;
            }

            while (end>=start){
                mid = (start+end)/2;
                if (nums[mid] > nums[mid+1]){
                    break;
                }
                if (nums[mid] >= nums[0]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }

            //二分查找
            if (potision){
                start = 0;
                end = mid;
            }else {
                start = mid+1;
                end = nums.length-1;
            }
        }
        //排除大于最大值和小于最小值的情况
        if (target > nums[end] || target<nums[start]){
            return -1;
        }

        while (end>=start){
            mid = (start+end)/2;
            if (nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            String key = toOrderChar(str);
            List<String> value = resultMap.get(key);
            if (value == null) {
                value = new ArrayList<>();
            }
            value.add(str);
            resultMap.put(key,value);
        }
        return new ArrayList<>(resultMap.values());
    }

    private String toOrderChar(String s){
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        return new String(sChars);
    }

    public int maxSubArray(int[] nums) {
        int[] maxArr = new int[nums.length];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                maxArr[i] = nums[i];
                continue;
            }
            maxArr[i] = Math.max(maxArr[i-1]+nums[i],nums[i]);
            if (maxArr[i] > max){
                max = maxArr[i];
            }
        }
        return max;
    }

    /**
     * 最远可到达位置，自解法，通过维护能否到达数组
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }

        boolean[] resArr = new boolean[nums.length];
        resArr[nums.length-1] = true;
        for (int i = nums.length-2; i >=0 ; i--) {
            resArr[i] = false;
            for (int j = 1; j <= nums[i]; j++) {
                if (resArr[i+j]){
                    resArr[i] = true;
                    break;
                }
            }
        }
        return resArr[0];
    }

    public boolean canJump1(int[] nums) {
        int maxReachLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i<=maxReachLength){
                maxReachLength = Math.max(maxReachLength,i+nums[i]);
            }
            if (maxReachLength >= nums.length-1){
                return true;
            }
        }
        return false;
    }

    /**
     * 48. 旋转图像
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 1){
            return;
        }
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            int reverseLine = n-1-i;
            for (int j = 0; j < n; j++) {
                repleace(matrix,i,j,reverseLine,j);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                repleace(matrix,i,j,j,i);
            }
        }
    }

    private void repleace(int[][] matrix,int i1,int j1,int i2,int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    /**
     * 56. 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] currInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 合并区间
            if (interval[0] <= currInterval[1]) {
                currInterval[1] = Math.max(currInterval[1],interval[1]);
                continue;
            }
            //不合并
            result.add(currInterval);
            currInterval = interval;
        }
        if (currInterval[0] != -1){
            result.add(currInterval);
        }
        int[][] arrResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arrResult[i] = result.get(i);
        }
        return arrResult;
    }

    /**
     * 剑指 Offer II 024. 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private ListNode reverDigui(ListNode head){
        if (head.next == null) return head;
        ListNode last = reverDigui(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 92. 反转链表 II
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null){
            return head;
        }
        if (left == right){
            return head;
        }
        int pre = left-1;
        int after = right+1;
        ListNode preNode = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode afterNode = null;
        int i = 1;
        ListNode index = head;
        while (i <= after){
            if (i == pre){
                preNode = index;
            }else if (i == left){
                leftNode = index;
            }else if (i == right){
                rightNode = index;
            }else if (i == after){
                afterNode = index;
            }
            if (i < after){
                index = index.next;
            }
            i++;
        }

        ListNode before = preNode;
        ListNode mid = leftNode;
        ListNode next = leftNode.next;
        for (int j = 0; j < right - left + 1; j++) {
            if (j == 0){
                mid.next = afterNode;
            }else {
                mid.next = before;
            }
            before = mid;
            mid = next;
            if (next != null){
                next = next.next;
            }
        }
        if (preNode != null){
            preNode.next = rightNode;
            return head;
        }else {
            return rightNode;
        }
    }

    /**
     * 25. K 个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode p = head;
        int i=1;
        while (i < k && p != null){
            p = p.next;
            i++;
        }
        if (p == null){
            return head;
        }
        if (i < k+1){
            return head;
        }
        if (p.next != null){
            p.next = reverseKGroup(p.next,k);
        }
        return reverseFrontK(head,k);
    }

    private ListNode reverseFrontK(ListNode head,int k){
        ListNode p = head;
        int i=0;
        while (p != null){
            p = p.next;
            i++;
        }
        if (i < k){
            return head;
        }

        ListNode pre = null;
        p = head;
        ListNode next = head.next;
        i=0;
        while (i<k){
            p.next = pre;
            pre = p;
            p = next;
            if (next != null){
                next = next.next;
            }
            i++;
        }
        head.next = p;
        return pre;
    }

    /**
     * 141. 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast!=null &&fast.next !=null){
                fast = fast.next.next;
            }else {
                return false;
            }
        }while (slow != fast);
        return true;
    }

    /**
     * 142. 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast!=null &&fast.next !=null){
                fast = fast.next.next;
            }else {
                return null;
            }
        }while (slow != fast);
        ListNode cyclePoint = head;
        while (cyclePoint != slow){
            cyclePoint = cyclePoint.next;
            slow = slow.next;
        }
        return cyclePoint;
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrace(result,candidates,target, new ArrayList(),0,0);
        return result;
    }

    private void backTrace(List<List<Integer>> result, int[] candidates, int target, List<Integer> curList, int index,int sum ){
        //回溯基本结构
        for (int i = index; i < candidates.length; i++) {
            curList.add(candidates[i]);
            int curSum = sum+candidates[i];
            if (curSum == target) {
                List<Integer> oneResult = new ArrayList<>(curList);
                result.add(oneResult);
                curList.remove(curList.size() - 1);
            } else if (curSum < target) {
                int gap = target - curSum;
                if (gap < candidates[i]){
                    curList.remove(curList.size() - 1);
                    continue;
                }
                backTrace(result, candidates, target, curList, i,curSum);
                curList.remove(curList.size() - 1);
            }else {
                curList.remove(curList.size() - 1);
                break;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            curList.add(nums[i]);
        }
        int n = nums.length;
        permuteBt(n,res,curList,0);
        return res;
    }

    private void permuteBt(int n, List<List<Integer>> res,List<Integer> curList,int index){
        if (index == n - 1) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i < n; i++) {
            Collections.swap(curList, index, i);
            permuteBt(n, res, curList, index + 1);
            Collections.swap(curList, i, index);
        }
    }

    /**
     * 62. 不同路径
     *
     * @param m
     * @param n
     * @return
     */

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        return npBackTrace(m, n, paths);
    }

    private int npBackTrace(int m, int n, int[][] paths) {
        if (paths[m - 1][n - 1] != 0) {
            return paths[m - 1][n - 1];
        }
        int down = npBackTrace(m - 1, n, paths);
        int right = npBackTrace(m, n - 1, paths);
        paths[m - 1][n - 1] = down + right;
        return paths[m - 1][n - 1];
    }

    /**
     * 64. 最小路径和
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        return minPathBackTrace(0, 0, paths, grid);
    }

    private int minPathBackTrace(int i, int j, int[][] paths, int[][] grid) {
        if (paths[i][j] != 0) {
            return paths[i][j];
        }
        if (i == paths.length - 1 && j == paths[0].length - 1) {
            paths[i][j] = grid[i][j];
            return paths[i][j];
        }
        if (i == paths.length - 1) {
            paths[i][j] = minPathBackTrace(i, j + 1, paths, grid) + grid[i][j];
            return paths[i][j];
        }
        if (j == paths[0].length - 1) {
            paths[i][j] = minPathBackTrace(i + 1, j, paths, grid) + grid[i][j];
            return paths[i][j];
        }
        int down = minPathBackTrace(i + 1, j, paths, grid);
        int right = minPathBackTrace(i, j + 1, paths, grid);
        paths[i][j] = Math.min(down, right) + grid[i][j];
        return paths[i][j];
    }

    /**
     * 70. 爬楼梯
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    /**
     * 94. 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        zhongxu(root, result);
        return result;
    }

    private void zhongxu(TreeNode treeNode, List<Integer> result) {
        if (treeNode.left == null && treeNode.right == null) {
            result.add(treeNode.val);
        } else if (treeNode.left == null) {
            result.add(treeNode.val);
            zhongxu(treeNode.right, result);
        } else if (treeNode.right == null) {
            zhongxu(treeNode.left, result);
            result.add(treeNode.val);
        } else {
            zhongxu(treeNode.left, result);
            result.add(treeNode.val);
            zhongxu(treeNode.right, result);
        }
    }

    /**
     * 94. 二叉树的中序遍历
     * 非递归中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root.left == null) {
                result.add(root.val);
                if (root.right == null) {
                    if (stack.empty()) {
                        break;
                    } else {
                        root = stack.pop();
                        root.left = null;
                    }
                } else {
                    root = root.right;
                }
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }

    /**
     * 96. 不同的二叉搜索树
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        //以i为root
        return numTreesDigui(n, nums);
    }

    /**
     * n个连续数字可以组成多少二叉树
     *
     * @param n
     * @param nums
     * @return
     */
    private int numTreesDigui(int n, int[] nums) {
        if (nums[n - 1] != 0) {
            return nums[n - 1];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum += numTreesDigui(n - 1, nums);
            } else if (i == n) {
                sum += numTreesDigui(n - 1, nums);
            } else {
                int left = numTreesDigui(i - 1, nums);
                int right = numTreesDigui(n - i, nums);
                sum += left * right;
            }
        }
        nums[n - 1] = sum;
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
        int[] intParam = {2, 7, 11, 15};
        int[] intParam2 = {2};
        //int[] result = new Solution().twoSum(intParam, 9);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l11.next = l12;
        l12.next = null;
//        ListNode result = new Solution().reverseBetween(l11,1,2);
//        System.out.println(result);
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = null;

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = null;

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        //System.out.println(new Solution().inorderTraversal2(t1));

//        ListNode listNode = new Solution().addTwoNumbers(l11, l21);
//        System.out.println(listNode);
//        System.out.println(new Solution().longestPalindrome("aaaaa"));
        //System.out.println(new Solution().findMedianSortedArrays(intParam, intParam2));
        //System.out.println(new Solution().reverse(9646324351L));
        //int [][] stops = {{10,60},{20,30},{30,30},{60,40}};
//        int[][] stops = {{25, 25}, {50, 50}};
        //int [][] stops = {};
//        System.out.println(new Solution().minRefuelStops(100, 50, stops));
//        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(new Solution().hammingDistance(3,1));
//        System.out.println(new Solution().isContinuity(new int[]{2,1,0,0,6}));
//        String s = "11";
//        String s1 = new String("1")+new String("1");
//        String s2 = new String("1")+new String("1");
//        String s3 = s1.intern();

//        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(new Solution().letterCombinations("23"));
//        StringBuffer sb = new StringBuffer("1234567");
//        sb.deleteCharAt(2);
//        sb.append('a');
//        System.out.println(sb);
//        ListNode _1 = new ListNode(1);
//        ListNode _2 = new ListNode(2);
//        ListNode _3 = new ListNode(3);
//        ListNode _4 = new ListNode(4);
//        ListNode _5 = new ListNode(5);
//        _1.next = _2;
//        _2.next = _3;
//        _3.next = _4;
//        _4.next = _5;
//        System.out.println(new Solution().removeNthFromEnd(_1,2));
//        new Solution().nextPermutation(new int[]{1,0,3,5,7,91,65});
//        System.out.println(new Solution().search(new int[]{4,5,1,2,3},1));
//        System.out.println(new Solution().canJump1(new int[]{3,2,1,0,4}));
    }
}
