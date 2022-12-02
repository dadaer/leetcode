package dynamicprogramming.knapsack01;

import java.util.Arrays;

/**
 * @source: leetcode416
 * @difficulty: medium
 * @topic: 分割等和子集
 * @link: https://leetcode.cn/problems/partition-equal-subset-sum/
 * @description: 给你一个只包含正整数的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @input: nums = [1,5,11,5]
 * @output: true
 * @requirements:
 */
public class CanPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int length = nums.length;
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 状态定义：从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j
        boolean[][] dp = new boolean[length][target + 1];
        // 初始化
        for (int i = 0; i < length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length - 1][target];
    }
}
