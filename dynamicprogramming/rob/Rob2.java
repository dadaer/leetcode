package dynamicprogramming.rob;

import java.util.Arrays;

/**
 * @source: leetcode213
 * @difficulty: medium
 * @topic: 打家劫舍II
 * @link: https://leetcode.cn/problems/house-robber-ii/
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * @input: [2,3,2]
 * @output: 3
 * @requirements:
 */
public class Rob2 {
    public static void main(String[] args) {
        System.out.println();
    }
    /**
     * 把环拆成两个队列，一个从 0 到 n - 1，另一个从 1 到 n，返回较大结果
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static int myRob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}
