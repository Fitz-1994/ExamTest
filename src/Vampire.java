import java.util.ArrayList;
import java.util.List;

/**
 * 求吸血鬼数字算法
 * @author forward
 */
public class Vampire {

    public static void main(String[] args) {
        List<Integer> vampore = new ArrayList<>();
        for (int i = 10;i<100;i++){
            for (int j=10;j<=i;j++){
                //如果乘积是吸血鬼数，就输出
                if (isVampire(i,j)){
                    System.out.println(i*j + " = "+ i +" * "+j);
                }
            }
        }
    }

    static boolean isVampire(Integer factor1, Integer factor2){
        Integer sum = factor1 * factor2;
        //只找出4位数的吸血鬼数字
        if (sum > 9999 || sum<1000){
            return false;
        }
        //以两个0结尾的数字是不允许的
        if (sum % 100 == 0){
            return false;
        }
        boolean isVampire = true;
        List<Integer> sumArr = new ArrayList<>();
        List<Integer> factorArr = new ArrayList<>();
        //将sum的数字加入到数组中
        sumArr.add(sum / 1000);
        sumArr.add((sum % 1000) / 100);
        sumArr.add((sum % 100) / 10);
        sumArr.add(sum % 10);
        //将factor的数字加入到数组中
        factorArr.add(factor1 / 10);
        factorArr.add(factor1 % 10);
        factorArr.add(factor2 / 10);
        factorArr.add(factor2 % 10);

        //判断sum中所有数字是否都包含在factor中
        for (Integer sumInt : sumArr) {
            if (!factorArr.contains(sumInt)){
                isVampire = false;
                break;
            }
        }
        //判断factor中所有数字是否都包含在sum中
        for (Integer factorInt : factorArr) {
            if (!sumArr.contains(factorInt)){
                isVampire = false;
                break;
            }
        }
        return isVampire;
    }
}
