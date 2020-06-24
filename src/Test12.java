import java.util.Arrays;

public class Test12 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     *
     * 典型的矩阵搜索问题，推荐使用回溯法。(暴力枚举 + 递归)
     */
    public static boolean exist(char[][] board, String word){
        int row, column;
        for (row = 0; row < board.length;row++){
            for (column = 0; column < board[0].length; column++){
                if (word.charAt(0) == board[row][column]){
                    char temp = board[row][column];
                    board[row][column] = '/';
                    if (judge(board, word, row, column, 0)){
                        return true;
                    }
                    board[row][column] = temp;
                }
            }
        }
        return false;
    }

    public static boolean judge(char[][] board, String word, int n, int m, int index){
        int row = n, column = m;
        index++;
        if (index == word.length())
            return true;
        if (row != 0){
            if (board[row-1][column] == word.charAt(index) && board[row-1][column] != '/'){
                char temp = board[row-1][column];
                board[row-1][column] = '/';
                if (judge(board, word, row-1, column, index)){
                    return true;
                }
                board[row-1][column] = temp;
            }
        }
        if (row != board.length - 1){
            if (board[row+1][column] == word.charAt(index) && board[row+1][column] != '/'){
                char temp = board[row+1][column];
                board[row+1][column] = '/';
                if (judge(board, word, row+1, column, index)){
                    return true;
                }
                board[row+1][column] = temp;
            }
        }
        if (column != 0){
            if (board[row][column-1] == word.charAt(index) && board[row][column-1] != '/'){
                char temp = board[row][column-1];
                board[row][column-1] = '/';
                if(judge(board, word, row, column-1, index)){
                    return true;
                }
                board[row][column-1] = temp;
            }
        }
        if (column != board[0].length - 1){
            if (board[row][column+1] == word.charAt(index) && board[row][column+1] != '/'){
                char temp = board[row][column+1];
                board[row][column+1] = '/';
                if(judge(board, word, row, column+1, index)){
                    return true;
                }
                board[row][column+1] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(exist(board,word));
    }
}
