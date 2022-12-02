package dynamicprogramming.medium;

/**
 * leetcode221
 * medium
 * 最大正方形
 */
public class MaximalSquare {
    public static void main(String[] args) {

    }

    public static int maximalSquare(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        // 状态定义：dp[i][j] 表示以 [i][j] 为右下角，且只包含 1 的正方形的边长最大值
        int[][] dp = new int[rowLength][colLength];
        int maxSide = 0;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                maxSide = Math.max(maxSide, dp[i][0]);
            }
        }
        for (int j = 0; j < colLength; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                maxSide = Math.max(maxSide, dp[0][j]);
            }
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 1) {
                    // 状态转移
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]) + 1; // Math.min 只能比较两个元素
                    System.out.println(dp[i][i]);
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
