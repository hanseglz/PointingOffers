
public class Test16 {
    /**
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     */
    public static double myPow(double x, int n){
        /**
         * 暴力乘法，将x乘n次
         * 时间复杂度：O(n)
         */
        if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        else if (n == -1)
            return 1/x;

        boolean negative = false;
        if (n < 0){
            negative = true;
            n = -n;
        }
        double temp = x;
        while (n != 1){
            x *= temp;
            n--;
        }

        return negative ? 1/x : x;
    }

    public static double myPow2(double x, int n){
        /**
         * 快速幂法
         * 具体实现方式为“二分法”或“二进制法”
         * 时间复杂度：O(logn)
         */
        if (n == 0)
            return 1.0;

        long alter = n; //如果n = -2147483647，直接取相反值后会越界。
        boolean negative = false;
        if (alter < 0){
            negative = true;
            alter = -alter;
        }

        double res = 1.0;
        double exp = x;
        while (alter != 0){
            if (alter % 2 == 1)
                res *= exp;
            exp *= exp;
            alter /= 2;
        }

        return negative ? 1/res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2.0,-2));
    }
}
