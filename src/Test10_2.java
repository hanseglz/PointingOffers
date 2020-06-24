
public class Test10_2 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 0 <= n <= 100
     */
    public static int numWays(int n){
        /**
         * 其实就是一个变相的斐波那契数列问题
         * 结题思路、注意事项同 Test10_1
         */
        int flag1 = 0, flag2 = 1;
        int tempSum;
        if (n == 0){
            return 1;
        }
        while (n > 0){
            tempSum = (flag1 + flag2) % 1000000007;
            flag1 = flag2;
            flag2 = tempSum;
            n--;
        }
        return flag2;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
