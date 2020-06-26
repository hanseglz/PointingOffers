import java.util.Arrays;

public class Test17 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 这道题真正的考点在于大数情况，即当n足够大（超出int乃至long可表示的范围）时的处理方法
     * 当n大于9时，int溢出；当n大于19时，long溢出。
     * 可以大数（超出int/long可表示范围）用字符串形式来表示,在字符串上模拟数字加法。
     */
    public static int[] printNumbers(int n){
        /**
         * 暴力法...
         * 时间复杂度：O(n)
         *
         * 虽然这个方法在LeetCode上一次通过，时间效率也符合要求，但是其实这并不是面试官希望看到的结果。
         */
        int max = (int)Math.pow(10,n);
        int[] res = new int[max - 1];
        for (int i = 0; i < max - 1; i++){
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}
