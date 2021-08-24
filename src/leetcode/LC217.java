package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LC217 {
    /**
     * 217. Contains Duplicate
     *
     * Given an integer array nums,
     * return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num: nums){
            if (!hashSet.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,1};
        System.out.println(containsDuplicate(arr));
    }
}
