import java.util.Arrays;

public class Test21 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10000
     */
    public static int[] exchange(int[] nums){
        /**
         * 首尾双指针
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        if (nums.length == 1)
            return nums;
        int head = 0, tail = nums.length - 1;
        while (head < tail){
            if (nums[head] % 2 == 0 && nums[tail] % 2 != 0){
                int temp;
                temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                head++;
            }else if (nums[tail] % 2 != 0){
                head++;
            }else if (nums[head] % 2 != 0){
                head++;
                tail--;
            }else{
                tail--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
