package hard;

/**
 * @source: leetcode44
 * @difficulty: hard
 * @topic: 通配符匹配
 * @link: https://leetcode.cn/problems/wildcard-matching/description/
 * @description: 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * @input: s = "adceb"  p = "*a*b"
 * @output: true
 * @explanation: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * @requirements:
 */
public class IsMatch {
    public static void main(String[] args) {

    }

    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        // dp[i][j] 表示 p 的前 j 个字符 对 s 的前 i 个字符的匹配情况
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];

        // 初始化
        // dp[0][0]=True，即当字符串 sss 和模式 ppp 均为空时，匹配成功；
        // dp[i][0]=False，即空模式无法匹配非空字符串；
        // dp[0][j] 需要分情况讨论：因为星号才能匹配空字符串，所以只有当模式 p 的前 j 个字符均为星号时，dp[0][j] 才为真。
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 递推
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 如果我们不使用这个星号，那么就会从 dp[i][j−1] 转移而来；
                    // 如果我们使用这个星号，那么就会从 dp[i−1][j] 转移而来

                    // 面对 *，它可以表示空字符，也就是说直接把去掉，看没有是否能匹配，即保持 i 不动，j - 1；
                    // 另一种情况是表示多个字符，我们得把留着，所以 j 不动， 然后看当前字符之前的字符是否也能被 * 匹配，如果之前字符能，
                    // 那么再加上现在的一个字符，* 就能匹配这几个连续字符了
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[sLength][pLength];
    }
}
