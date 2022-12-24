package matrix;

/**
 * @source: leetcode59
 * @difficulty: medium
 * @topic: 螺旋矩阵 II
 * @link: https://leetcode.cn/problems/spiral-matrix-ii/
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @input: 3
 * @output: [[1, 2, 3],[8, 9, 4],[7, 6, 5]]
 * @requirements:
 */
public class GenerateMatrix {
    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int n) {
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int index = 1;
        int[][] ans = new int[n][n];
        while (true) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = index++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom ; i++) {
                ans[i][right] = index++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = index++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = index++;
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
