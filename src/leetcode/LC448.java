package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC448 {
    /**
     * 448. Find All Numbers Disappeared in an Array
     *
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     *
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if (len == 1)
            return list;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++){
            if (!hashSet.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(arr);
        for (int num : list){
            System.out.println(num);
        }
    }

}
