package dynamicprogramming.completeKnapsack;

/**
 * leetcode377
 * medium
 * 组合总和4
 * 属于完全背包排列问题
 *
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 5}, 5));

    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 排列问题可重复
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
