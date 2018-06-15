/**
 * 利用for循环求素数
 * @author forward
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int count = 1;
        //System.out.print("2 ");
        //i表示要求的素数
        for (int i = 3;i<1000000;i++){
            boolean isPrime = true;
            for (int j =2;j<i;j++){
                //取余数等于0代表可以被整除
                if (i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                count++;
                if (count % 100 == 0){
                    System.out.println("count = "+count);
                }
                //System.out.print(i + " ");
                //System.out.println("count = "+count);
            }
        }
        //System.out.println("count = "+count);
    }
}
