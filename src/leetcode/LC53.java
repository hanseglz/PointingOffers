package leetcode;

import java.util.Arrays;

public class LC53 {
    /**
     * 53. Maximum Subarray
     *
     * Given an integer array nums, find the contiguous(相邻的) subarray (containing at least one number)
     * which has the largest sum and return its sum.
     * A subarray is a contiguous part of an array.
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public static int maxSubArray(int[] nums) {
        if (nums == null)
            return 0;
        else if (nums.length == 1)
            return nums[0];

        boolean allNegative = true;
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0){
                allNegative = false;
            }
            if (sum + nums[i] < 0){
                sum = 0;
            }else{
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }

        if (allNegative){
            Arrays.sort(nums);
            res = nums[nums.length - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1,0,-1};
        System.out.println(maxSubArray(nums));
    }
}
