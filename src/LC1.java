import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] twoSum(int[] nums, int target){
        /**
         * Hashmap
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i){
                return new int[] {i, map.get(remain)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
