package array.easy;

/**
 * @source: leetcode566
 * @difficulty: easy
 * @topic: 重塑矩阵
 * @link: https://leetcode.cn/problems/reshape-the-matrix/
 * @description: 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * @input: mat = [[1,2],[3,4]], r = 1, c = 4
 * @output: [[1,2,3,4]]
 * @requirements:
 */
public class MatrixReshape_ {
    public static void main(String[] args) {

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        if (r * c != rowLength * colLength) {
            return mat;
        }
        int ret[][] = new int[r][c];
        int rowIndex = 0;
        int colIndex = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // 循环内会遍历到原矩阵的每一个元素，只需在此给新矩阵赋值即可
                if (colIndex >= c) {
                    rowIndex++;
                    colIndex = 0;
                }
                ret[rowIndex][colIndex] = mat[i][j];
                colIndex++;
            }
        }
        return ret;
    }
}
