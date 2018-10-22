package webank;

import java.util.Scanner;

public class Class1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }
    static String GetResult(int N) {
        //direction 表示方向， 0 1 2 3 分别表示 右上方 右方 左下方 下方
        int direction = 0;
        //index 表示目前查找的数量
        int index = 0;
        int a = 0;
        int b = 0;
        while (index < N-1){
            //向右上方移动
            if (direction % 4 == 0){
                if (b == 0){
                    direction = direction+1 % 4;
                }else {
                    a++;
                    b--;
                    index++;
                }
                //向右方移动
            }else if (direction % 4 == 1){
                a++;
                index++;
                direction = direction+1 % 4;
                //向左下方移动
            }else if (direction % 4 == 2){
                if(a == 0){
                    direction = direction+1 % 4;
                }else {
                    a--;
                    b++;
                    index++;
                }
            }else {
                //这里是向下方移动
                b++;
                index++;
                direction = direction+1 % 4;
            }
        }
        int left = a+1;
        int right = b+1;
        return right+"/"+left;
    }
}
