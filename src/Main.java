public class Main {

    public static void main(String[] args) {
        int[] arr1 = {0, 2, 5, 6, 10, 11};
        int[] arr2 = {1, 3, 4, 12};

        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;
        int[] result = new int[arr1.length + arr2.length];

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[resultIndex] = arr1[index1];
                index1++;
            } else {
                result[resultIndex] = arr2[index2];
                index2++;
            }
            resultIndex++;
        }
        int[] leftArr;
        int leftIndex;
        if (index1 == arr1.length) {
            leftArr = arr2;
            leftIndex = index2;
        } else {
            leftArr = arr1;
            leftIndex = index1;
        }
        for (; leftIndex < leftArr.length; leftIndex++) {
            result[resultIndex] = leftArr[leftIndex];
            resultIndex++;
        }

        System.out.println(result);


    }
}
