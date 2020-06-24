
public class Test10_1 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 0 <= n <= 100
     */

    public static int fib(int n){
        /**
         * 暴力穷举法
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         * 需要注意的点：题目之所以要取模，是因为int类型最大只能表示2^31 - 1大小的数（约为2e9)
         * 为了避免溢出，需要每次进行加法运算后，对结果直接取模，然后再变量间数值转换
         */
        int flag1 = 0, flag2 = 1;
        int tempSum;
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }
        while (n > 1){
            tempSum = (flag1 + flag2) % 1000000007;
            flag1 = flag2;
            flag2 = tempSum;
            n--;
        }
        return flag2;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
