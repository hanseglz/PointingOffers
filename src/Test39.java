import java.util.HashMap;
import java.util.Hashtable;

public class Test39 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 1 <= 数组长度 <= 50000
     */
    public static int majorityElement(int[] nums){
        /**
         * 暴力/哈希表统计法，从头遍历数组
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        int len = nums.length;
        if (len == 1 || len == 2)
            return nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++){
            if (!hashMap.containsKey(nums[i]))
                hashMap.put(nums[i], 1);
            else{
                int count = hashMap.get(nums[i]);
                if (count + 1 > len / 2)
                    return nums[i];
                hashMap.put(nums[i], count + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,9,9,10};
        System.out.println(majorityElement(nums));
    }
}
