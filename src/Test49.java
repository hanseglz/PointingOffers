import java.util.LinkedList;
import java.util.List;

public class Test49 {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     * 1 是丑数。
     * n 不超过 1690。
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public static int nthUglyNumber(int n){
        /**
         * 动态规划
         * 这道题很巧妙
         * 如果遍历自然数数列，判断每个数是否是丑数，则一定会超时，我们应该focus on丑数自身的性质
         * 丑数的性质：任何一个丑数一定是由一个比它自身小的丑数 * 2/3/5得来的
         * 因此，我们可以设计一个链表，表头为1，同时有三个指针，分别代表*2 *3 *5指针，都指向表头
         * 每次扩展链表尾部时，尾部的值为 min(a*2, b*3, c*5)，并移动相应指针，如果发生类似 a*2 = b*3 的情况，则同时移动a和b
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        if (n == 0 || n == 1)
            return n;
        List<Integer> list = new LinkedList<>();
        list.add(1);
        int a = 0, b = 0, c = 0;
        n--;

        while (n > 0){
            list.add(minNum(list.get(a) * 2, list.get(b) * 3, list.get(c) * 5));
            if (list.get(list.size() - 1) == list.get(a) * 2)
                a++;
            if (list.get(list.size() - 1) == list.get(b) * 3)
                b++;
            if (list.get(list.size() - 1) == list.get(c) * 5)
                c++;
            n--;
        }
        return list.get(list.size() - 1);
    }

    public static int minNum(int a, int b, int c){
        return Math.min(Math.min(a,b), c);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
