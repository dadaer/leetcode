package dynamicprogramming.knapsack01;

/**
 * @source: leetcode474
 * @difficulty: medium
 * @topic: 一和零
 * @link: https://leetcode.cn/problems/ones-and-zeroes/
 * @description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * @input: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * @output: 4
 * @requirements:
 */
public class FindMaxForm {
    public static void main(String[] args) {

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // 状态定义:在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zeros || k < ones) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
