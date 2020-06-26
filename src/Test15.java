
public class Test15 {
    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */
    // you need to treat n as an unsigned value
    public static int hammingWeight(long n){
        int count = 0;
        while (n != 0){
            if (n % 2 == 1){
                count++;
                n--;
            }
            n /= 2;
        }
        return count;
    }

    public static int hammingWeight2(int n){
        /**
         * 妙用与运算（&）： n & 1 来判断一个数的最后一位是否为1
         * 通过右移运算>>= / 无符号右移运算>>>= 实现数位移动
         * 时间复杂度：O(logn)
         * 空间复杂度：O(1)
         */
        int count = 0;
        while (n != 0){
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(9));
    }
}
