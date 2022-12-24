package matrix;

import java.util.Arrays;

/**
 * @source: leetcode48
 * @difficulty: medium
 * @topic: 旋转图像
 * @link: https://leetcode.cn/problems/rotate-image/
 * @description: 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * @input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * @output: [[7,4,1],[8,5,2],[9,6,3]]
 * @requirements: 必须在 原地 旋转图像，不要 使用另一个矩阵来旋转图像
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(rotate(matrix)[i]));
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        return matrix;
    }
}
