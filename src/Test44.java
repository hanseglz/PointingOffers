import java.util.Stack;

public class Test44 {
    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     *
     * 0 <= n < 2^31
     */
    public static int findNthDigit(int n){
        /**
         * Yet another mathematical problem
         */
        long ten = 90;
        int digit = 2;
        if (n < 10)
            return n;
        n -= 10;
        while (n > ten * digit){
            n -= ten * digit;
            ten *= 10;
            digit++;
        }
        int rest = n % digit;
        String str = String.valueOf((int)Math.pow(10, digit - 1) + n / digit);
        int res = Integer.parseInt(str.substring(rest, rest + 1));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(999999999));
    }
}
