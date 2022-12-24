package dynamicprogramming.medium;

/**
 * @source: leetcode91
 * @difficulty: medium
 * @topic: 解码方法
 * @link: https://leetcode.cn/problems/decode-ways/description/
 * @description:
 * @input: s = "226"
 * @output: 3
 * @description: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 * @requirements: "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价
 */
public class NumDecodings_ {
    public static void main(String[] args) {

    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;

        // 状态转移
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
