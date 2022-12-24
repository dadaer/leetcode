package dynamicprogramming.medium;

/**
 * @source: 剑指offer
 * @difficulty: medium
 * @topic: 把数字翻译成字符串
 * @link: https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @input: 12258
 * @output: 5
 * @explanation 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi" 和 "mzi"
 * @requirements:
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum1(419605557));
    }

    public static int translateNum1(int num) {
        String number = String.valueOf(num);
        int length = number.length();

        // 定义dp数组 dp[i] 表示 [0, i] 下标范围内可以组成翻译的方法数
        int[] dp = new int[length];

        // 初始化
        dp[0] = 1;
        if (length == 1) {
            return dp[0];
        }
        dp[1] = Integer.parseInt(number.substring(0, 2)) <= 25 ? 2 : 1;

        // 递推
        for (int i = 2; i < length; i++) {
            dp[i] = dp[i - 1];
            int index = number.charAt(i) - '0';
            if ((number.charAt(i - 1) == '1' && index <= 9) || (number.charAt(i - 1) == '2' && index <= 5)) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[length - 1];
    }

    /**
     * 实际上很类似于跳台阶问题，只是多了一个判断
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int len = ch.length;
        // 状态定义：dp[i]表示前 i 位有多少个翻译
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            // 状态转移
            if (n >= 10 && n <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
