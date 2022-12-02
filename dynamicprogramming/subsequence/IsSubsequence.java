package dynamicprogramming.subsequence;

/**
 * @source: leetcode392
 * @difficulty: easy
 * @topic: 判断子序列
 * @link: https://leetcode.cn/problems/is-subsequence/
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * @input: s = "abc", t = "ahbgdc"
 * @output: true
 * @requirements:
 */
public class IsSubsequence {
    public static void main(String[] args) {

    }

    public static boolean isSubsequence(String s, String t) {
        int M = s.length();
        int N = t.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N] == s.length();
    }
}
