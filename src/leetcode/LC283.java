package leetcode;

import java.util.Arrays;

public class LC283 {
    /**
     * 283. Move Zeroes
     *
     * Given an integer array nums, move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    public static void moveZeroes(int[] nums) {
        /**
         * A very simple question, just need to figure out the steps of re-arranging the array.
         * Talk is cheap, the code is cheaper for this one.
         */
        if (nums.length == 1)
            return;

        int newIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[newIndex++] = nums[i];
            }
        }
        for (int i = newIndex; i < nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
