package dynamicprogramming.subsequence;

/**
 * @source: leetcode718
 * @difficulty: medium
 * @topic: 最长公共子数组
 * @link: https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 * @description: 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * @input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * @output: 3
 * @requirements:
 */
public class FindLength {
    public static void main(String[] args) {

    }

    public static int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
