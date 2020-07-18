
public class Test47 {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     * 0 < grid.length <= 200
     * 0 < grid[0].length <= 200
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */
    private static int res = 0;

    public static int maxValue(int[][] grid){
        /**
         * 简单动态规划法，类似Test12
         * 本题不可使用，会造成时间超限
         */
        int maxRow = grid.length;
        int maxColumn = grid[0].length;
        int n = 0, m = 0, sum = 0;
        crawl(grid, n, m, sum);
        return res;
    }

    public static void crawl(int[][] grid, int row, int column, int sum){
        if (row == grid.length - 1 && column == grid[0].length - 1){
            sum += grid[row][column];
            res = Math.max(res, sum);
            return;
        }
        sum += grid[row][column];
        if (row != grid.length - 1)
            crawl(grid, row + 1, column, sum);
        if (column != grid[0].length - 1)
            crawl(grid, row, column + 1, sum);
    }

    public static int maxValue2(int[][] grid){
        /**
         * 题目说明：从棋盘的左上角开始拿格子里的礼物，并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。
         * 根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。
         * 设 f(i,j) 为从棋盘左上角走至单元格 (i,j) 的礼物最大累计价值，易得到以下递推关系：
         * f(i,j) 等于 f(i,j−1) 和 f(i−1,j) 中的较大值加上当前单元格礼物价值 grid(i,j) 。 即：
         *                  f(i,j) = max[f(i,j−1),f(i−1,j)] + grid(i,j)
         * 因此，可用动态规划解决此问题，以上公式便为转移方程。
         */
        for (int j = 0; j < grid[0].length; j++){
            if (j == 0)
                continue;
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 0; i < grid.length; i++){
            if (i == 0)
                continue;
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(maxValue2(grid));
    }
}
