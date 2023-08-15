package bitoperation;

/**
 * @source: 剑指offer65
 * @difficulty: easy
 * @topic: 不用加减乘除做加法
 * @link: https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @description: 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @input: a = 1, b = 1
 * @output: 2
 * @explanation:
 * @requirements:
 */
public class Add {
    public static void main(String[] args) {

    }

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
