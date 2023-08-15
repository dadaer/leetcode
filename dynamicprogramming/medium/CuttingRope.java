package dynamicprogramming.medium;

/**
 * @source: 剑指offer14 - I
 * @difficulty: medium
 * @topic: 剪绳子
 * @link: https://leetcode.cn/problems/jian-sheng-zi-lcof/description/
 * @description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @input: 10
 * @output: 36
 * @explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * @requirements:
 */
public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int n) {
        // n <= 3的情况，要求 m > 1 必须要分段
        // 例如 3 必须分成1、2 或 1、1、1 ，n = 3 最大分段乘积是 2, 同理 2 的最大乘积为 1
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];

        // 下面 3 行是 n >= 4 的情况，跟 n <= 3 不同，4 可以分很多段，比如分成 1、3
        // 这里的 3 可以不需要再分了，因为 3 分段最大才 2，不分就是 3。记录最大的
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
