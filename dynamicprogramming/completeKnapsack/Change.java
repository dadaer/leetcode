package dynamicprogramming.completeKnapsack;

/**
 * leetcode518
 * medium
 * 零钱兑换2
 * 属于完全背包组合问题
 */
public class Change {
    public static void main(String[] args) {

        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change0(5, new int[]{1, 2, 5}));

    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // 状态转移：类比爬楼梯问题
                // 外层循环是遍历数组 coins 的值，内层循环是遍历不同的金额之和
                // 在计算 [i] 的值时，可以确保金额之和等于 i 的硬币面额的顺序
                // 由于顺序确定，因此不会重复计算不同的排列
                dp[i] += dp[i - coin];
                System.out.print(dp[i] + "\t");

            }
            System.out.println();
        }
        return dp[amount];
    }

    public static int change0(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                    System.out.println(dp[j] + "\t");
                }
            }
            System.out.println();
        }
        return dp[amount];
    }

    public static int change1(int amount, int[] coins) {
        // 状态定义：dp[i][j] 表示在 [0,i] 下标范围内选取若干个硬币得到总和为 j 的组合数
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 用前 k 的硬币凑齐金额 j ，要分为两种情况计算
                    // 一种是没有用第 k 个硬币就凑齐了，一种是前面已经凑到了 j - coins[k] ，现在就差第 k 个硬币了
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // 根据二维数组定义， coins[k - 1] 表示第 k 个硬币
                }
            }
        }
        return dp[coins.length][amount];
    }
}
