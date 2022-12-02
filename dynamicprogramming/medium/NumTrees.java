package dynamicprogramming.medium;

/**
 * @source: leetcode96
 * @difficulty: medium
 * @topic: 不同的二叉搜索树
 * @link: https://leetcode.cn/problems/unique-binary-search-trees/
 * @description: 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @input: n = 3
 * @output: 5
 * @requirements:
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= i / 2 + 1; j++) {
                    int i1 = dp[j - 1] * dp[i - j] * 2;
                    if (j == 1) {
                        dp[i] += dp[i - j] * 2;
                    } else if (j == i / 2 + 1) {
                        dp[i] += dp[j - 1] * dp[i - j];
                    } else {
                        dp[i] += i1;
                    }
                }
            } else {
                for (int j = 1; j <= i / 2; j++) {
                    int i1 = dp[j - 1] * dp[i - j] * 2;
                    if (j == 1) {
                        dp[i] += dp[i - j] * 2;
                    } else {
                        dp[i] += i1;
                    }
                }
            }
        }
        return dp[n];
    }
}
