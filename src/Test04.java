
public class Test04 {
    /**
     *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 0 <= n <= 1000, 0 <= m <= 1000
     *
     * @param matrix
     * @param target
     */

    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        /**
         * 暴力解法，遍历矩阵中的每一个元素
         * 时间复杂度：O(nm)
         * 空间复杂度：O(1)
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int n = 0; n < row; n++){
            for (int m = 0; m < column; m++){
                if (matrix[n][m] == target)
                    return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target){
        /**
         * 线性查找
         * 从右上角开始遍历，如果num > target则指针向下，如果num < target则指针向左，target若存在最后一定能找到。
         * 时间复杂度：O(n+m)
         * 空间复杂度：O(1)
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int n = 0;
        int m = column - 1;
        while (m > -1 && n < row){
            if (matrix[n][m] == target)
                return true;
            if (matrix[n][m] < target){
                n++;
                continue;
            }
            if (matrix[n][m] > target){
                m--;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 23;
        System.out.println(findNumberIn2DArray2(matrix, target));
    }

}
