import java.util.Arrays;

public class Test45 {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 0 < nums.length <= 100
     * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
     * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    public static String minNumber(int[] nums){
        /**
         * 我们可以重新定义数组中数之间的大小关系，比方说：
         * 对于3和30，因为330 > 303，所以3 > 30
         * 采用类似冒泡排序的方法重新sort，最后按序输出即可
         *
         * 时间复杂度：O(N^2)
         * 空间复杂度：O(N)
         */
        StringBuilder res = new StringBuilder();
        int len = nums.length;
        if (len == 1)
            return String.valueOf(nums[0]);

        for (int i = 0; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                if (strCompare(nums[i], nums[j])){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < len; i++){
            res.append(nums[i]);
        }
        return res.toString();
    }

    public static boolean strCompare(int a, int b){
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        String cmp1 = str1 + str2;
        String cmp2 = str2 + str1;
        if (cmp1.compareTo(cmp2) > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(minNumber(arr));
    }
}
