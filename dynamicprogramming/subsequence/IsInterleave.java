package dynamicprogramming.subsequence;

/**
 * @source: leetcode97
 * @difficulty: medium
 * @topic: 交错字符串
 * @link: https://leetcode.cn/problems/interleaving-string/
 * @description: 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * @input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * @output: true
 * @requirements:
 */
public class IsInterleave {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    // 动态规划方法
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }

        // dp 数组含义: dp(i,j) 表示 s1 的前 i 个元素和 s2 的前 j 个元素能否组成 s3 的前 i + j 个元素
        // 即 令 p = i + j - 1
        // dp[i][j] = (dp[i][j - 1] && s1[i - 1] == s3[p]) or (dp[i - 1][j] && s2[j - 1] == s3[p])
        boolean[][] dp = new boolean[n + 1][m + 1];

        // 初始化
        dp[0][0] = true;

        // 递推
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p)); // 注意下标
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[n][m];
    }

    // dfs方法 超时
    public static boolean isInterleave1(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0, 0);
    }

    private static boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j ,k + 1)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1,k + 1)) {
            return true;
        }
        return false;
    }

    // 记忆化搜索
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int n=s1.length(),m=s2.length();
        if((n+m)!=s3.length()) return false;
        boolean[][] dp=new boolean[n][m];
        return backtrack(s1,s2,s3,0,0,0,dp);
    }

    public static boolean backtrack(String s1,String s2,String s3,int p1,int p2,int p3,boolean[][] dp){
        if(p3==s3.length()) {
            return true;
        }
        if(p1<s1.length() && p2<s2.length() && dp[p1][p2]) {
            return false;
        }
        if(p1<s1.length() && s1.charAt(p1)==s3.charAt(p3)){
            if(backtrack(s1,s2,s3,p1+1,p2,p3+1,dp)) {
                return true;
            }
        }
        if(p2<s2.length() && s2.charAt(p2)==s3.charAt(p3)){
            if(backtrack(s1,s2,s3,p1,p2+1,p3+1,dp)) {
                return true;
            }
        }
        if(p1<s1.length() && p2<s2.length()) {
            dp[p1][p2]=true;
        }
        return false;
    }
}
