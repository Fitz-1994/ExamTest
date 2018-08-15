package niukewang.netease;

import java.util.Scanner;

/**
 * 完成率30%
 * 链接：https://www.nowcoder.com/discuss/93285
 * 来源：牛客网
 *
 * 又到了丰收的季节，恰好小易去牛牛的果园里游玩。 牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。 在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。 牛牛觉得问题太简单了，所以希望你来替他回答。
 *
 * 输入描述
 * 第一行 一个数 n (1<= n <= $10^5$)
 * 第二行 n个数 $a{i}$ (1<=$a{i}$<=1000),表示从左往右数第i堆有多少苹果
 * 第三行 一个数m (1<= m <= $10^5$),表示有m次询问
 * 第四行 m个数$q{i}$, 表示小易希望知道第$q{i}$个苹果属于哪一堆。
 *
 * 输出描述
 * m行，第i行输出第$q_{i}$个苹果属于哪一堆。
 *
 * 示例
 * 输入
 *
 * 1 5
 * 2 2 7 3 4 9
 * 3 3
 * 4 1 25 11
 * 输出
 *
 * 1 1
 * 2 5
 * 3 3
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] q = new int[m];
        for (int i=0;i<m;i++){
            q[i] = in.nextInt();
        }
        int[][] aSum = new int[n][2];
        int total = 0;
        for (int i=0;i<n;i++){
            aSum[i][0] = a[i];
            aSum[i][1] = total + a[i];
            total = aSum[i][1];
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int pre = 0;
                int late = aSum[j][1];
                if (j != 0){
                    pre = aSum[j-1][1];
                }
                if (q[i] >= pre && q[i]<= late){
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
