package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC15 {
    /**
     * 15. 3Sum
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        if (nums[0] > 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end){
                if (nums[start] + nums[end] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    while (start < end && nums[start] == nums[start+1])
                        start++;
                    while (start < end && nums[end] == nums[end-1])
                        end--;
                    start++;
                    end--;
                } else if (nums[start] + nums[end] > target){
                    end--;
                } else {
                    start++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
    }
}
