package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @source: leetcode20
 * @difficulty: easy
 * @topic: 有效的括号
 * @link: https://leetcode.cn/problems/valid-parentheses/
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @input: "()[]{}"
 * @output: true
 * @requirements:
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        if (length % 2 != 0) {
            return false;
        }

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != map.get(s.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
