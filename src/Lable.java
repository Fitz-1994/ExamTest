/**
 * Java标签的使用方法
 * @author forward
 */
public class Lable {
    public static void main(String[] args) {
        outter:
        for (int i=0;i<10;i++){
            System.out.println("i = "+i);
            inner:
            for (int j=0;j<10;j++){
                System.out.println("j = "+j);
                if (j == 5){
                    break inner;
                }
                if (i== 5){
                    break outter;
                }
            }

        }
    }
}
