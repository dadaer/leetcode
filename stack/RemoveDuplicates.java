package stack;

import java.util.Stack;

/**
 * @source: leetcode1047
 * @difficulty: easy
 * @topic: 删除字符串中的所有相邻重复项
 * @link: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * @description: 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * @input: "abbaca"
 * @output: "ca"
 * @requirements:
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }


    public static String removeDuplicates1(String s) {
        int length = s.length();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (stack1.isEmpty()) {
                stack1.push(s.charAt(i));
            } else {
                if (s.charAt(i) == stack1.peek()) {
                    stack1.pop();
                } else {
                    stack1.push(s.charAt(i));
                }
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            stringBuilder.append(stack2.pop());
        }

        return new String(stringBuilder);
    }
}
