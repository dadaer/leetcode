package string.easy;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @source: leetcode20
 * @difficulty: easy
 * @topic: 有效的括号
 * @link: https://leetcode.cn/problems/valid-parentheses/
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @input: s = "()[]{}"
 * @output: true
 * @requirements:
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    if (map.get(s.charAt(i)) != stack.peek() ) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
