package leetcode;

import java.util.Arrays;
import java.util.EnumSet;

public class LC45 {
    /**
     * 45. Jump Game II
     *
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     *
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     * Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    public static int jump(int[] nums) {
        int res;
        if (nums.length == 1 || nums.length == 2)
            return nums.length-1;

        res = jump(nums, 0);
        return res;
    }

    public static int jump(int[] nums, int count){
        if (nums.length == 1)
            return count;
        if (nums[0] == 0)
            return 10000;

        int flag = 10000;
        for (int i = 1; i <= nums[0] && i < nums.length; i++){
            flag = Math.min(flag, jump(Arrays.copyOfRange(nums,i,nums.length), count + 1));
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,0,1,4};
        System.out.println(jump(arr));
    }
}
