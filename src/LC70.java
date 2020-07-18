public class LC70 {
    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    public static int climbStairs(int n){
        if (n == 1 || n == 2 || n == 3)
            return n;
        int step1 = 1, step2 = 1;
        while (--n > 0){
            int temp = step2;
            step2 += step1;
            step1 = temp;
        }
        return step2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
