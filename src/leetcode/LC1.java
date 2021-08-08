package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {
    /**
     * 1. Two sum
     */
    public static int[] twoSum1(int[] nums, int target){
        int[] res = new int[2];
        int[] noRes = new int[2];
        noRes[0] = -1;
        noRes[1] = -1;
        boolean haveRes = false;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int rest = target - nums[i];
            if (hashMap.containsKey(rest) && i != hashMap.get(rest)){
                res[0] = i;
                res[1] = hashMap.get(rest);
                haveRes = true;
                break;
            }
        }
        return haveRes ? res : noRes;
    }

    public static int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int rest = target - nums[i];
            if (hashMap.containsKey(rest) && hashMap.get(rest) != i){
                ans[0] = i;
                ans[1] = hashMap.get(rest);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,5};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
