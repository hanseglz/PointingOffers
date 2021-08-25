package leetcode;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;

public class LC48 {
    /**
     * 48. Rotate Image
     *
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     */
    public static void rotate(int[][] matrix) {
        if (matrix.length == 1)
            return;

        for (int i = 0; i < matrix.length / 2; i++){
            for (int j = i; j < matrix.length - 1 - i; j++){
                switchFour(matrix, i, j);
            }
        }
    }

    public static void switchFour(int[][] matrix, int x, int y){
        int temp = matrix[x][y];
        int len = matrix.length;
        matrix[x][y] = matrix[len-1-y][x];
        matrix[len-1-y][x] = matrix[len-1-x][len-1-y];
        matrix[len-1-x][len-1-y] = matrix[y][len-1-x];
        matrix[y][len-1-x] = temp;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(arr);
        for (int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
