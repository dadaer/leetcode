package dynamicprogramming.medium;

/**
 * @source: leetcode63
 * @difficulty: medium
 * @topic: 不同路径II
 * @link: https://leetcode.cn/problems/unique-paths-ii/
 * @description: 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * @output: 2
 * @requirements:
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) { // 终止条件重要
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}
