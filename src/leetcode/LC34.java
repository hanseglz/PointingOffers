package leetcode;

import java.util.Arrays;

public class LC34 {
    /**
     * 34. Find First and Last Position of Element in Sorted Array
     *
     * Given an array of integers nums sorted in ascending order,
     * find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     */
    public static int[] searchRange(int[] nums, int target) {
        /**
         * Like the question 33, we cannot traverse the whole array cuz O(logn) demanding.
         * Maybe we should try for binary search again.
         */
        int[] res = new int[]{-1,-1};
        if (nums.length == 0 || nums.length == 1 && nums[0] != target)
            return new int[]{-1,-1};
        if (nums.length == 1)
            return new int[]{0,0};

        int head = 0, tail = nums.length - 1, middle;
        while (head <= tail){
            middle = head + (tail - head) / 2;
            if (nums[middle] == target){
                int flag = middle;
                while (flag >= 0 && nums[flag] == target)
                    flag--;
                res[0] = flag + 1;
                flag = middle;
                while (flag < nums.length && nums[flag] == target)
                    flag++;
                res[1] = flag - 1;
                break;
            } else if (nums[middle] > target){
                tail = middle - 1;
            } else {
                head = middle + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,4};
        System.out.println(Arrays.toString(searchRange(arr, 4)));
    }
}
