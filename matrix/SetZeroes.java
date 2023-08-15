package matrix;

import java.util.Arrays;

/**
 * @source: leetcode73
 * @difficulty: medium
 * @topic: 矩阵置0
 * @link: https://leetcode.cn/problems/jump-game-ii/
 * @description: 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0
 * @input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * @output: [[1,0,1],[0,0,0],[1,0,1]]
 * @explanation:
 * @requirements: 使用 原地 算法
 */
public class SetZeroes {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        //判断首行
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        boolean colFlag = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag){
            Arrays.fill(matrix[0], 0);
        }
        if (colFlag){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
