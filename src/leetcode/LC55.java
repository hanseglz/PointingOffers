package leetcode;

public class LC55 {
    /**
     * 55. Jump Game
     *
     * You are given an integer array nums.
     * You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
     * which makes it impossible to reach the last index.
     */
    public static boolean canJump(int[] nums){
        if (nums.length == 1)
            return true;
        else if (nums.length == 2 && nums[0] == 0)
            return false;

        int furthest = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (i <= furthest){
                furthest = Math.max(furthest, i + nums[i]);
            } else
                return false;
        }

        return furthest >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
