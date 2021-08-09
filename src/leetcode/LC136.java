package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC136 {
    /**
     * 136. Single Number
     *
     * Given a non-empty array of integers nums,
     * every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     */

    public static int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            if (hashSet.contains(num))
                hashSet.remove(num);
            else
                hashSet.add(num);
        }
        for (int num : nums)
            if (hashSet.contains(num))
                return num;

        return -1;
    }

    public static int singleNumber2(int[] nums){
        /**
         * A more tricky one.
         */
        int res = 0;
        for (int num : nums){
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber2(arr));
    }
}
