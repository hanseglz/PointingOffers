package leetcode;

import java.util.Arrays;

public class LC31 {
    /**
     * 31. Next Permutation
     * @param nums
     *
     * Implement next permutation(排列), which rearranges numbers
     * into the lexicographically(字典顺序的,i.e. 1<1215<130<20<3) next greater permutation of numbers.
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order
     * (i.e., sorted in ascending order).
     * The replacement must be in place and use only constant extra memory.
     *
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     */

    public static void nextPermutation(int[] nums) {
        /**
         * Single Pass Approach
         *
         * The key of this question is to figure out how to mathematically find out
         * the lexicographically next greater permutation.
         * Start from the tail of the list, looking for the first index i that makes nums[i]>nums[i-1],
         * then we looking for the smallest element in the subarray nums[i, len], call it nums[j]
         * (make sure nums[j] is bigger than nums[i-1]),
         * then we exchange nums[i-1] with nums[j], and simply sort the subarray nums[i, len].
         *
         * Time complexity: O(n)
         */
        if (nums == null || nums.length == 1)
            return;

        boolean isChange = false;
        for (int flag = nums.length - 1; flag > 0; flag--){
            if (nums[flag] > nums[flag-1]){
                int smallIndex = flag;
                for (int i = flag; i < nums.length; i++){
                    if (nums[i] < nums[smallIndex] && nums[i] > nums[flag-1]){
                        smallIndex = i;
                    }
                }
                int temp = nums[flag-1];
                nums[flag-1] = nums[smallIndex];
                nums[smallIndex] = temp;
                Arrays.sort(nums, flag, nums.length);
                isChange = true;
                break;
            }
        }

        if (!isChange){
            Arrays.sort(nums);
        }
//Brutal time equals to O(n!)
//        int len = nums.length;
//        int[] res = Arrays.copyOfRange(nums, 0, len);
//        int leftFlag = 0;
//        int rightFlag = len - 1;
//        for (; rightFlag >=0; rightFlag--){
//            if (res[rightFlag] < res[len-1]){
//                int temp = res[rightFlag];
//                res[rightFlag] = res[len-1];
//                res[len-1] = temp;
//                leftFlag = rightFlag;
//                rightFlag = len - 1;
//                break;
//            }
//        }
//        if (Arrays.equals(nums, res)){
//            Arrays.sort(nums);
//            return;
//        }
//        while (rightFlag > ++leftFlag){
//            if (res[rightFlag] < res[leftFlag]){
//                int temp = res[rightFlag];
//                res[rightFlag] = res[leftFlag];
//                res[leftFlag] = temp;
//                leftFlag = rightFlag;
//                rightFlag = len - 1;
//            }else{
//                rightFlag--;
//            }
//        }
//        for(int i = 0; i < len; i++){
//            nums[i] = res[i];
//        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
