package dynamicprogramming.subsequence;

/**
 * @source: leetcode1143
 * @difficulty: medium
 * @topic: 最长公共子序列
 * @link: https://leetcode.cn/problems/longest-common-subsequence/
 * @description:
 * @input: text1 = "abcde", text2 = "ace"
 * @output: 3
 * @requirements:
 */
public class LCS {
    public static void main(String[] args) {

    }

    public static int lCS(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }
}
