package dynamicprogramming.rob;

/**
 * @source: leetcode198
 * @difficulty: medium
 * @topic: 打家劫舍
 * @link: https://leetcode.cn/problems/house-robber/description/
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * @input: [1,2,3,1]
 * @output: 4
 * @requirements:
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = nums[0];
        // 递推
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[length];
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        // 状态定义：dp[i]表示前i天偷窃到的最高金额
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            // 状态转移
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
