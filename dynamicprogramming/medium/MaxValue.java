package dynamicprogramming.medium;

/**
 * @source: 剑指offer47
 * @difficulty: medium
 * @topic: 礼物的最大价值
 * @link: https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @input: [[1,3,1], [1,5,1], [4,2,1]]
 * @output: 12
 * @requirements:
 */
public class MaxValue {
    public static void main(String[] args) {

    }

    public static int maxValue(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        // 状态定义 dp[i][j]表示下标为[i][j]的最大价值
        int[][] dp = new int[rowLength + 1][colLength + 1]; // 解决边界问题
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                // 状态转移
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]; // 这里下标注意
            }
        }
        return dp[rowLength][colLength];
    }
}
