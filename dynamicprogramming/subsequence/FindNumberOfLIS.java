package dynamicprogramming.subsequence;

/**
 * @source: leetcode673
 * @difficulty: medium
 * @topic: 最长递增子序列的个数
 * @link: https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
 * @description: 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 * @input: [1,3,5,4,7]
 * @output: 2
 * @requirements:
 */
public class FindNumberOfLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] count = new int[length];
        int maxLen = 0;
        int ans = 1;

        // 递推
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = count[i];
            } else if (dp[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }
}
