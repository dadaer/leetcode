package design;

import java.util.Stack;

/**
 * @source: leetcode227
 * @difficulty: medium
 * @topic: 基本计算器 II
 * @link: https://leetcode.cn/problems/basic-calculator-ii/
 * @description: 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * @input: s = "3 + 2 * 2"
 * @output: 7
 * @requirements:
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 23 / 2 "));
    }

    public static int calculate(String s) {
        char sign = '+';
        Stack<Integer> numStack = new Stack<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') {
                // 记录当前数字。先减，防溢出
                num = num * 10 - '0' + cur;
            }
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                // 判断上一个符号是什么
                switch (sign) {
                    // 当前符号前的数字直接压栈
                    case '+' -> numStack.push(num);
                    // 当前符号前的数字取反压栈
                    case '-' -> numStack.push(-num);
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*' -> numStack.push(numStack.pop() * num);
                    // 数字栈栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/' -> numStack.push(numStack.pop() / num);
                }
                // 记录当前符号
                sign = cur;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }
}
