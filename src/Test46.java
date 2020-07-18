import java.util.HashMap;

public class Test46 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：
     * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * 0 <= num < 2^31
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public static int translateNum(int num){
        /**
         * 类似Test10_2青蛙跳台阶问题
         * 所有青蛙跳台阶问题的本质都是斐波那契数列问题
         * 由于要考虑部分两位数无法形成对应英文字母，所以比斐波那契数列要复杂一些，核心思想是动态规划DP
         * 将数转换成字符串后，从头遍历字符串
         * 对于普通的斐波那契数列，在遍历的过程中，每一个元素的值等于其前两个元素之值的和
         * 对于本题这种特殊的情况，在每次遍历时，判断数字和前一位数字所组成的两位数能否映射到某个英文字母上
         * 如果不能，则不可以f(n) = f(n-1) + f(n-2)，而应该f(n) = f(n-1) !!!!!
         *
         * 时间复杂度：O(logn)
         * 空间复杂度：O(n)
         */
        if (num < 10)
            return 1;
        if (num < 26)
            return 2;
        if (num < 100)
            return 1;

        String str = String.valueOf(num);
        int flag1 = 1, flag2 = 1;
        for (int i = 2; i < str.length() + 1; i++){
            if (str.substring(i - 2, i).compareTo("10") >= 0 && str.substring(i - 2, i).compareTo("25") <= 0){
                int temp = flag2;
                flag2 += flag1;
                flag1 = temp;
            }else{
                flag1 = flag2;
            }
        }
        return flag2;
    }

    public static void main(String[] args) {
        int n = 1225823;
        System.out.println(translateNum(n));
    }
}
