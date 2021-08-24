package leetcode;

import java.util.HashMap;

public class LC219 {
    /**
     * 219. Contains Duplicate II
     *
     * Given an integer array nums and an integer k,
     * return true if there are two distinct indices i and j in the array
     * such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!hashMap.containsKey(nums[i]))
                hashMap.put(nums[i], i);
            else if (i - hashMap.get(nums[i]) <= k){
                return true;
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr, 1));
    }
}
