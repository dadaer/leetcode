package math;

/**
 * @source: leetcode172
 * @difficulty: medium
 * @topic: 阶乘后的零
 * @link: https://leetcode.cn/problems/factorial-trailing-zeroes/description/
 * @description: 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * @input: n = 5
 * @output: 1
 * @explanation: 5! = 120 ，有一个尾随 0
 * @requirements:
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}


