import java.util.Arrays;

public class sortMergeDemo {
    /**
     * 归并排序
     */
    public static void mergeSort(int[] nums, int head, int tail){
        if (nums == null || head == tail)
            return;

        int mid = head + (tail - head) / 2;
        mergeSort(nums, head, mid);
        mergeSort(nums, mid + 1, tail);
        merge(nums, head, tail, mid);

        System.out.println(Arrays.toString(nums));
        return;
    }

    public static void merge(int[] nums, int head, int tail, int mid){
        int[] temp = new int[tail - head + 1];
        int i = head, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= tail){
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= tail)
            temp[k++] = nums[j++];

        for(k = 0; k < tail - head + 1; k++)
            nums[k + head] = temp[k];
        return;
    }

    public static void main(String[] args) {
        int[] nums = {9,7,5,3,1,8,6,4,2};
        int head = 0, tail = nums.length - 1;
        mergeSort(nums, head, tail);
        System.out.println("The final result: " + Arrays.toString(nums));
    }
}
