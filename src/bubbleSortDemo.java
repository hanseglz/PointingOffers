import java.util.Arrays;

public class bubbleSortDemo {
    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] arr){
        if (arr.length == 0)
            return arr;

        int len = arr.length;
        for (int i = 0; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,3,9,1};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
