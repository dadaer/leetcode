package dynamicprogramming.easy;

/**
 * @source: leetcode70
 * @difficulty: easy
 * @topic: 爬楼梯
 * @link: https://leetcode.cn/problems/climbing-stairs/
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @input: n = 3
 * @output: 3
 * @requirements:
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        // 状态定义：dp[i] 表示爬到第 i 级台阶有多少种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 状态转移
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
