package matrix;

/**
 * 剑指offer29
 * easy
 * 顺时针打印矩阵
 */
public class SpiralOrder {
    public static void main(String[] args) {
        spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
    }

    public static int[] spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] ans = new int[rowLength * colLength];
        int index = 0;
        int top = 0;
        int bottom = rowLength - 1;
        int left = 0;
        int right = colLength - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom ; i++) {
                ans[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                ans[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
