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
        /**
         * The optimal time complexity of this one is O(n).
         * To achieve that, the method could be a little bit tricky to come up with.
         * We traverse the array from start to nums.length - 1,
         * each time, we record currently the furthest position we could make it,
         * and if we are at the exact point of the furthest, we update it.
         * Anyway, talk is cheap.
         */
        if (nums.length == 1 || nums.length == 2)
            return nums.length - 1;

        int flag = 0, furthest = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            furthest = Math.max(furthest, i + nums[i]);
            if (flag == i){
                count++;
                flag = furthest;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,0,1,4};
        System.out.println(jump(arr));
    }
}
