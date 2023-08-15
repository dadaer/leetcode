package stack;

import java.util.Stack;

/**
 * @source: leetcode678
 * @difficulty: medium
 * @topic: 有效的括号字符串
 * @link: https://leetcode.cn/problems/valid-parenthesis-string/description/
 * @description: 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * @input: "(*))"
 * @output: true
 * @requirements:
 */
public class CheckValidString {
    public static void main(String[] args) {

    }

    public static boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int length = s.length();
        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (c == '*') {
                stack2.push(i);
            } else if (c == '(') {
                stack1.push(i);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else {
                    if (stack2.isEmpty()) {
                        return false;
                    } else {
                        stack2.pop();
                    }
                }
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int leftIndex = stack1.pop();
            int asteriskIndex = stack2.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return stack1.isEmpty();
    }

    /**
     * 如果遇到左括号，则将最小值和最大值分别加 1
     * 如果遇到右括号，则将最小值和最大值分别减 1
     * 如果遇到星号，则将最小值减 1，将最大值加 1
     * 任何情况下，未匹配的左括号数量必须非负，因此当最大值变成负数时，说明没有左括号可以和右括号匹配，返回 false
     * 当最小值为 0 时，不应将最小值继续减少，以确保最小值非负
     * 遍历结束时，所有的左括号都应和右括号匹配，因此只有当最小值为 0 时，字符串 s 才是有效的括号字符串
     */
    public static boolean checkValidString1(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}
