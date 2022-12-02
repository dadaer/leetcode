package array.medium;

/**
 * @source: leetcode53
 * @difficulty: easy
 * @topic: 最大子数组和
 * @link: https://leetcode.cn/problems/maximum-subarray/
 * @description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * @output: 6
 * @requirements:
 */
public class MaxSubArray_ {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5}));
    }

    // 前缀和
    public static int maxSubArray(int[] nums) {
        // 前缀和初始化是nums[0]
        int prefix = nums[0];
        int minPrefix = nums[0];
        int maxSubArray = Integer.MIN_VALUE;
        for (int num : nums) {
            prefix += num;
            // 先减去minPrefix,再更新
            maxSubArray = Math.max(maxSubArray, prefix - minPrefix);
            minPrefix = Math.min(prefix, minPrefix);
        }
        return maxSubArray;
    }

    // 动态规划
    public static int maxSubArray1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        // 状态定义 dp[i]表示nums[i]结尾的最大子数组和
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
