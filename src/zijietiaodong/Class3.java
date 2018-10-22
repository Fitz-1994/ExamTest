package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (m == 0 || n == 0){
            System.out.println(0);
            return;
        }
        int[][] serverLinked = new int[n][n];
        List<GuangLan> guangLans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            guangLans.add(new GuangLan(in.nextInt()-1,in.nextInt()-1));
        }
        int[] cutOrder = new int[m];
        for (int i = 0; i < m; i++) {
            cutOrder[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            GuangLan g = guangLans.get(i);
            serverLinked[g.a][g.b] = 1;
            serverLinked[g.b][g.a] = 1;
        }
        for (int i = 0; i < cutOrder.length; i++) {
            GuangLan g = guangLans.get(cutOrder[i]-1);
            serverLinked[g.a][g.b] = 0;
            serverLinked[g.b][g.a] = 0;
            if (!linked(serverLinked)){
                System.out.println(i+1);
                break;
            }
        }
    }
    public static boolean linked(int[][] servers){
        boolean res = true;
        for (int i = 0; i < servers.length; i++) {
            boolean lineRes = false;
            for (int j = 0; j < servers[i].length; j++) {
                if (servers[i][j] == 1){
                    lineRes = true;
                    break;
                }
            }
            if (!lineRes){
                res = false;
                break;
            }
        }
        return res;
    }
}
class GuangLan{
    int a;
    int b;
    GuangLan(int a, int b){
        this.a = a;
        this.b = b;
    }
}