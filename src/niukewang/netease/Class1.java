package niukewang.netease;

import java.util.Scanner;

/**
 * 该文件夹三道题为网易2019届校招考试题，三题均超时未完成
 * 该题完成率50%
 *
 * 链接：https://www.nowcoder.com/questionTerminal/93f2c11daeaf45959bb47e7894047085?orderByHotValue=1&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 *
 *
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 * 示例1
 * 输入
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 * 输出
 * 16
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] interests = new int[n][2];
        for (int i=0;i<n;i++){
            interests[i][0] = in.nextInt();
        }
        for (int i=0;i<n;i++){
            interests[i][1] = in.nextInt();
        }
        int maxInterest = 0;
        for (int i=0;i<n;i++){
            if (interests[i][1] == 0) {
                int[][] temp = wakeUp(interests, i, k);
                int interest = 0;
                for (int j = 0; j < n; j++) {
                    if (temp[j][1] == 1) {
                        interest += temp[j][0];
                    }
                }
                if (interest > maxInterest) {
                    maxInterest = interest;
                }
            }
        }
        System.out.println(maxInterest);
    }
    public static int[][] wakeUp(int[][] interests,int index,int time){
        int[][] temp = new int[interests.length][2];
        for (int i=0;i<interests.length;i++){
            temp[i][0] = interests[i][0];
            temp[i][1] = interests[i][1];
        }
        for (int i=0;i<time;i++){
            if (index+i < interests.length) {
                temp[index + i][1] = 1;
            }
        }
        return temp;
    }
}
