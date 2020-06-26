import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Test13 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * 需要注意有些格子虽然满足条件依然到不了，比如说k=4时(0,10)是到不了的。
     */
    //todo
    public static int movingCount(int m, int n, int k){
        /**
         * 回bao溯li算法，类似Test12
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        int count = 0;
        return count;
    }

    public static int numSum(int i, int j){
        return i%10 + i/100 + i/10%10 + j%10 + j/100 + j/10%10;
    }

    public static int bfs(int m, int n, int k){
        /**
         * 广度优先遍历
         * 是队列，我加了队列 ！
         * 在Java中，队列不能像栈、哈希表等通过Queue queue = new Queue()来实现
         * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
         */
        //Java中boolean类型默认值是false
        boolean visited[][] = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0){
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j])
                continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bfs(14,14,5));
    }
}
