
public class Test43 {
    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     *
     * 1 <= n < 2^31
     */
    public static int countDigitOne(int n){
        /**
         * 一道数学题
         * 想法很绕，实现很简单
         */
        int times = 1;
        int res = 0;
        int quotient, rest;
        int origin = n;
        while (n != 0){
            rest = n % 10;
            quotient = n / 10;
            if (rest == 0){
                res += quotient * times;
            }else if (rest > 1){
                res += (quotient + 1) * times;
            }else{
                res += quotient * times + (origin - n * times) + 1;
            }
            n /= 10;
            times *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }
}
