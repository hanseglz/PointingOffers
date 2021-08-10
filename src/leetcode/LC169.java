package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC169 {
    /**
     * 169. Majority Element
     *
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
            }else{
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
        }
        int flag = Integer.MIN_VALUE;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if (entry.getValue().compareTo(flag) > 0){
                flag = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,1,2,1,1,1,2};
        System.out.println(majorityElement(arr));
    }
}
