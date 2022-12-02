package dynamicprogramming.subsequence;

/**
 * @source: leetcode300
 * @difficulty: medium
 * @topic: 最长递增子序列
 * @link: https://leetcode.cn/problems/longest-increasing-subsequence/
 * @description:
 * @input: nums = [10,9,2,5,3,7,101,18]
 * @output: 4
 * @requirements:
 */
public class LengthOfLIS_ {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // 状态转移：dp[i] 的值代表以 nums[i] 结尾的最长子序列长度
        int[] dp = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 状态转移
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
