
public class Test42 {
    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     * 1 <= arr.length <= 10^5
     * -100 <= arr[i] <= 100
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public static int maxSubArray(int[] nums){
        /**
         * 题目要求时间复杂度为O(n)，不能暴力回溯
         * 比较简单的一道题
         */
        int len = nums.length;
        int res = nums[0];
        if (len == 1)
            return res;

        int i = 0;
        int sum = res;
        while (++i < len){
            if (sum < 0){
                sum = Math.max(sum, nums[i]);
                res = Math.max(res, sum);
                continue;
            }
            sum += nums[i];
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
