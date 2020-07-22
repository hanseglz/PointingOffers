import java.util.Arrays;

public class sortQuickDemo {
    /**
     * 快排
     * 设置两个变量i、j，排序开始的时候：i=0，j=N-1；
     * 以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
     * 从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]的值交换；
     * 从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]的值交换；
     * 重复第3、4步，直到i=j；
     * 3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。
     * 找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
     */
    public static void quickSort(int[] nums, int left, int right){
        if (left == right)
            return;
        int i = left, j = right;
        while (i < j){
            while (nums[j] > nums[left] && i < j)
                j--;
            while (nums[i] < nums[left] && i < j)
                i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        System.out.println("left: "+ left + " right: " + right+ " nums: " + Arrays.toString(nums));
        quickSort(nums, left + 1, right);
        quickSort(nums, left, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5,7,2,8,4,1,9,3,6};
        int left = 0, right = arr.length - 1;
        quickSort(arr, left, right);
        System.out.println(Arrays.toString(arr));
    }
}
