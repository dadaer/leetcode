package dynamicprogramming.completeKnapsack;

import java.util.Arrays;

/**
 * @source: leetcode279
 * @difficulty: medium
 * @topic: 完全平方数
 * @link: https://leetcode.cn/problems/perfect-squares/description/
 * @description: 给你一个整数 n ，返回和为 n 的完全平方数的最少数量。
 * @input: n = 12
 * @output: 3
 * @requirements:
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        // 状态定义：dp[i] 表示整数 i 完全平方数的最少数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                // 状态转移
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
