package dynamicprogramming.medium;

/**
 * @source: leetcode413
 * @difficulty: medium
 * @topic: 等差数列划分
 * @link: https://leetcode.cn/problems/arithmetic-slices/
 * @description: 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的子数组个数。子数组是数组中的一个连续序列。
 * @input: nums = [1,2,3,4]
 * @output: 3
 * @requirements:
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return 0;
        }
        // 状态定义：dp[i] 表示以 nums[i] 结尾的等差数列的个数
        int[] dp = new int[length];
        for (int i = 2; i < length; i++) {
            // 状态转移
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int count= 0;
        for (int i = 2; i < length; i++) {
            count += dp[i];
        }
        return count;
    }
}
