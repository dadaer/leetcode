package dynamicprogramming.completeKnapsack;

import java.util.Arrays;

/**
 * leetcode322
 * medium
 * 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // 状态定义：dp[i]表示 amount 为 i 所需要的最少零钱个数
        int[] dp = new int[amount + 1];
        // 初始化为最大值，且可以用来判断无法组合的情况
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // 状态转移
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
