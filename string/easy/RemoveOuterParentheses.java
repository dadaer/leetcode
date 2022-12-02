package string.easy;

import java.util.Stack;

/**
 * @source: leetcode1021
 * @difficulty: easy
 * @topic: 删除最外层的括号
 * @link: https://leetcode.cn/problems/remove-outermost-parentheses/
 * @description:
 * @input: s = "(()())(())"
 * @output: "()()()"
 * @requirements:
 */
public class RemoveOuterParentheses{
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int i;
        for (i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                res.append(s.substring(startIndex + 1, i - 1));
                startIndex = i;
            }
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        res.append(s.substring(startIndex + 1, i - 1));
        return res.toString();
    }

    public static String removeOuterParentheses1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (isValid(s.substring(start, i + 1))) {
                stringBuilder.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return new String(stringBuilder);
    }

    private static boolean isValid(String substring) {
        Stack<Character> stack = new Stack<>();
        int length = substring.length();
        for (int i = 0; i < length; i++) {
            char c = substring.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
