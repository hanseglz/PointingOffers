import java.util.Arrays;

public class sortSelectionDemo {
    /**
     * 选择排序
     */
    public static int[] selectSort(int[] nums){
        int min;
        int len = nums.length;
        if (len == 0 || len == 1)
            return nums;
        for (int i = 0; i < len - 1; i++){
            min = nums[i];
            for (int j = i + 1; j < len; j++){
                if (min > nums[j]){
                    nums[i] = nums[j];
                    nums[j] = min;
                    min = nums[i];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,7,1,9};
        System.out.println(Arrays.toString(selectSort(arr)));
    }
}
