package leetcode;

import java.util.Arrays;

public class LC33 {
    /**
     * 33. Search in Rotated Sorted Array
     *
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
     * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * Given the array nums after the rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */
    public static int search(int[] nums, int target) {
        /**
         * Since the question asks for O(logn), we can't traverse the whole array or use data structures like map.
         * To accelerate the program, we must utilize the feature of the array, which is its rangy ascending.
         * Again, this question is a pure IQ test.
         */
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int left, int right, int target){
        int middle = left + (right - left) / 2;
        while (left != right){
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle-1;
            else
                left = middle+1;
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(search(arr, 1));
    }
}
