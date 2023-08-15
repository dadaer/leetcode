package dynamicprogramming.medium;

/**
 * @source: 剑指offer60
 * @difficulty: medium
 * @topic: n个骰子的点数
 * @link: https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/description/
 * @description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * @input: 2
 * @output: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * @explanation:
 * @requirements:
 */
public class DicesProbability {
    public static void main(String[] args) {
        System.out.println(dicesProbability(2));
    }

    public static double[] dicesProbability(int n) {
        double[] res = new double[5 * n + 1];

        // dp
        int[][] dp = new int[n + 1][6 * n + 1];

        // 初始化
        for (int i = 0; i <= 6; i++) {
            dp[1][i] = 1;
        }

        // 递推
        // dp[i][j] 表示前 i 个骰子和为 j 出现的次数
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6 && k < j; k++) {
                    dp[i][j] +=  dp[i - 1][j - k];
                }
            }
        }

        double totalNum = Math.pow(6, n);

        int index = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[index++] = dp[n][i] / totalNum;
        }

        return res;
    }
}
