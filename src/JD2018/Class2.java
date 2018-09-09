package JD2018;

import java.util.*;

/**
 * 对比
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 *
 * 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 *
 * 输入
 * 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。
 *
 * 输出
 * 输出包含一个整数，表示不合格品的数量。
 *
 *
 * 样例输入
 * 3
 * 1 4 2
 * 4 3 2
 * 2 5 3
 * 样例输出
 * 1
 *
 * Hint
 * 样例解释
 * 物品1的a,b,c均小于物品3的a,b,c,因此1为不合格品。
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int itemNum = in.nextInt();
        List<Item> itemList = new ArrayList<>();
        for (int i=0;i<itemNum;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Item item = new Item(a,b,c);
            itemList.add(item);
        }
        Set<Item> itemSet = new HashSet<>();
        for (int i=0;i<itemList.size();i++){
            for (int j=i+1;j<itemList.size();j++){
                Item badItem = Item.badItem(itemList.get(i),itemList.get(j));
                if (badItem != null){
                    itemSet.add(badItem);
                }
            }
        }
        System.out.println(itemSet.size());
    }
}
class Item {
    int a;
    int b;
    int c;

    Item(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Item badItem(Item A, Item B){
        if (A.a > B.a && A.b > B.b && A.c>B.c){
            return B;
        }
        if (A.a < B.a && A.b < B.b && A.c<B.c){
            return A;
        }
        return null;
    }
}
