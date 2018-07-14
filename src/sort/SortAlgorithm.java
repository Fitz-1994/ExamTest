package sort;

/**
 * 排序算法类
 * 该类中的排序算法都针对整数进行从小到大的排序
 * @author forward
 */
public class SortAlgorithm {

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static void bubble(int[] arr){
        //这里i表示的是已经确定位置的个数，j表示本次要比较的数的位置，比较j和j+1位置上的数
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                //判断这两个是否是反序
                if (arr[j]>arr[j+1]){
                    SortAlgorithm.exchange(arr,j,j+1);
                }
            }
        }
    }

    public static int[] exchange(int[] arr,int index1 ,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {9,5,1,3,4,7,8,3,4};
        SortAlgorithm.bubble(array);
        for (int a:array){
            System.out.print(a+" ");
        }
    }
}
