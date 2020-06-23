import java.util.Arrays;
import java.util.HashSet;

public class Test03 {
    /**
    * 找出数组中重复的数字。
    * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    * 请找出数组中任意一个重复的数字。
    * 2 <= n <= 100000
    *
    * @param nums 待查找的数组
     * @return 任意一个重复的数字
    */

    public static int findRepeatNumber(int[] nums){
        /**
         * 先排序，再查重
         * 时间 O(nlogn)
         * 空间 O(n)
         */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return 1;
    }

    public static int findRepeatNumber2(int[] nums){
        /**
         * 利用HashMap
         * 时间 O(n)
         * 空间 O(n)
         */
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums){
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }
}
