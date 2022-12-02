package dynamicprogramming.medium;

/**
 * @source: leetcode64
 * @difficulty: medium
 * @topic: 最小路径和
 * @link: https://leetcode.cn/problems/minimum-path-sum/
 * @description: 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @input: [[1,3,1],[1,5,1],[4,2,1]]
 * @output: 7
 * @requirements: 每次只能向下或者向右移动一步。
 */
public class MinPathSum {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        if(colLength == 0) {
            return 0;
        }
        int[][] dp = new int[rowLength][colLength];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowLength; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < colLength; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowLength - 1][colLength - 1];
    }
}
