package beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            gameList.add(new Game(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
        }
        for (int i=0;i<T;i++){
            System.out.println(gameList.get(i).pk());
        }
    }
}
class Game{
    int X;
    int A;
    int C;
    int Y;
    int B;
    int D;
    Game(int X,int A,int C,int Y,int B,int D){
        this.X = X;
        this.A = A;
        this.C = C;
        this.Y = Y;
        this.B = B;
        this.D = D;
    }

    public String pk(){
        int zhiCold = 0;
        int chunCold = 0;
        while (X>0 && Y>0){
            //小春的冷却时间更短，小春先发起进攻
            if (zhiCold > chunCold){
                X = X - B;
                zhiCold = zhiCold - chunCold;
                chunCold = D;
            }else if (zhiCold < chunCold){
                //小智的冷却时间更短，小智发起进攻
                Y = Y - A;
                chunCold = chunCold - zhiCold;
                zhiCold = C;
            }else {
                //双方同时发起进攻
                X = X - B;
                Y = Y - A;
                chunCold = D;
                zhiCold = C;
            }
        }
        if (X > 0){
            return "XIAOZHI";
        }else {
            if (Y > 0){
                return "XIAOCHUN";
            }else {
                return "TIE";
            }
        }
    }
}
