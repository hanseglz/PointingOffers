
public class Test14_2 {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
     * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 2 <= n <= 1000
     *
     * 与14_1类似，只不过取消了大数限制，需要考虑数据溢出的情况（取模）
     */
    public static int cuttingRope(int n){
        if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        long res = 1;
        while (n > 4){
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        if (n == 4){
            res *= 4;
            res %= 1000000007;
        }else if (n == 3){
            res *= 3;
            res %= 1000000007;
        }
        else if (n == 2){
            res *= 2;
            res %= 1000000007;
        }
        /*else if (n == 1){
            //因为要考虑溢出的情况，有可能之前的res是刚刚被取了模的，如果那样的话这里就不能简单的先÷3再x4，因为除以三的对象应该是取模前的res
            res = res / 3 * 2 * 2;
            res %= 1000000007;
        }*/
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(127));
    }
}
