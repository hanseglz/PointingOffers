package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {
    /**
     * 1. Two sum
     */
    public static int[] twoSum(int[] nums, int target){
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

    public static void main(String[] args) {
        int[] nums = {2,11,15,7,3};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
