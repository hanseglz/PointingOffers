import java.util.Arrays;

public class Test40 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     */
    public static int[] getLeastNumbers(int[] nums, int k){
        /**
         * 直接排序解决战斗
         *
         * 时间复杂度：O(nlogn)
         * 空间复杂度：O(n)
         */
        int[] res = new int[k];
        if (k == 0)
            return res;
        Arrays.sort(nums);
        return Arrays.copyOfRange(nums, 0, k);
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        System.out.println(Arrays.toString(getLeastNumbers(arr,1)));
    }
}
