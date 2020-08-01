import java.util.Arrays;

public class Test51 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * 0 <= 数组长度 <= 50000
     */
    private static int res = 0;

    public static int reversePairs(int[] nums){
        /**
         * 时间复杂度为O(n^2)的暴力方法是必然不行的······
         * 这道题的思路非常复杂，不仅要求对归并排序的执行步骤、原理十分了解，还需要明白为什么归并过程中能统计出逆序对数量，涉及到大量递归。
         * 归并排序的思路参考sortMergeDemo中的示范
         * 以数组 [7,5,6,4]为例，在归并过程中，当数组被细分为最小的[7] [5] [6] [4]后，因为7 > 5,6 > 4,故（count++）++
         * 变成[5,7] [4,6]后，因为5 > 4，所以count+=2，然后5 < 6无变化，7 > 6， count++，最后count = 5.
         * 即在归并排序的基础上，每次merge时，如果前数组元素大于后数组元素，则count += 当前前数组index位到末尾元素个数
         */
        if (nums == null || nums.length == 0)
            return 0;
        int head = 0, tail = nums.length - 1;
        mergePairs(nums, head, tail);
        return res;
    }

    public static void mergePairs(int[] nums, int head, int tail){
        if (head == tail)
            return;

        int mid = head + (tail - head) / 2;
        mergePairs(nums, head, mid);
        mergePairs(nums, mid + 1, tail);
        merge(nums, head, tail);
        return;
    }

    public static void merge(int[] nums, int head, int tail){
        int[] temp = new int[tail - head + 1];
        int mid = head + (tail - head) / 2;
        int i = head, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= tail){
            if (nums[i] > nums[j]){
                res += mid - i + 1;
                temp[k++] = nums[j++];
            }else
                temp[k++] = nums[i++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= tail)
            temp[k++] = nums[j++];

        for (k = 0; k < tail - head + 1; k++)
            nums[k + head] = temp[k];

        return;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(reversePairs(nums));
//        System.out.println(Arrays.toString(nums));
    }
}
