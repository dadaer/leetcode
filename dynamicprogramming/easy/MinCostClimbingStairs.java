package dynamicprogramming.easy;

/**
 * @source: leetcode746
 * @difficulty: easy
 * @topic: 使用最小花费爬楼梯
 * @link: https://leetcode.cn/problems/min-cost-climbing-stairs/
 * @description: 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费。
 * @input: cost = [10,15,20]
 * @output: 15
 * @requirements:
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 2];
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i <= length + 1; i++) {
            dp[i] = Math.min(dp[i -1] + cost[i - 2], dp[i - 2] + cost[i - 3]);

        }
        return dp[length + 1];
    }
}
