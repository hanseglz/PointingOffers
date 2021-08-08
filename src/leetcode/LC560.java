package leetcode;

import java.util.HashMap;

public class LC560 {
    /**
     * 560. Subarray Sum Equals K
     *
     * Given an array of integers nums and an integer k,
     * return the total number of continuous subarrays whose sum equals to k.
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     */

    public static int subarraySum(int[] nums, int k){
        /**
         * Using Cumulative Sum
         * the sum of subarray i to j equals to sum[j] - sum[i-1]
         *
         * time complexity: O(n^2)
         */
        if (nums.length == 0 || nums.length == 1 && nums[0] != k)
            return 0;
        else if (nums.length == 1)
            return 1;

        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = 1; i < sum.length; i++){
            for (int j = i; j < sum.length; j++){
                if (k == sum[j] - sum[i-1]){
                    res++;
                }
            }
        }
        return res;
    }

    public static int subarraySum2(int[] nums, int k){
        /**
         * Using hashmap
         *
         * Firstly, we use a hashmap to store every sum of a subarray start with index 0;
         * The core is：
         * if a sum in the hashmap subtract k equals to
         * a number with already contained in the hashmap as a key element，
         * then it means that their is a subarray which sum of its elements is k.
         * Comparing to the first solution, this one use hashmap to avoid an extra traverse to the array,
         * therefore lower the time complexity to O(n).
         *
         *
         * time complexity: O(n)
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0, res = 0;
        hashMap.put(0,1);

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (hashMap.containsKey(sum - k)){
                res+=hashMap.get(sum-k);
            }
            if (hashMap.getOrDefault(sum,0) == 0){
                hashMap.put(sum,1);
            }else{
                hashMap.put(sum,hashMap.get(sum)+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int k = 0;
        System.out.println(subarraySum2(nums, k));
    }
}
