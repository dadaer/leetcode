package math;

/**
 * @source: 剑指offer49
 * @difficulty: medium
 * @topic: 丑数
 * @link: https://leetcode.cn/problems/chou-shu-lcof/
 * @description: 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @input: n = 10
 * @output: 12
 * @explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * @requirements:
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
        int i = 2;
        while (n > 1) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                n--;
            }
            i++;
        }
        return i - 1;
    }
}
