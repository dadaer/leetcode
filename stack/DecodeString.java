package stack;

import java.util.Stack;

/**
 * leetcode139
 * medium
 * 单词拆分
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!stack.empty() && Character.isLetter(stack.peek())) {
                    sb.insert(0,stack.pop());
                }
                String sub = sb.toString();
                stack.pop();
                StringBuilder sb1 = new StringBuilder();
                // 获取数字
                while(!stack.empty() && Character.isDigit(stack.peek())) {
                    sb1.insert(0,stack.pop());
                }
                int count = Integer.valueOf(sb1.toString());
                while (count > 0) {
                    for (char c : sub.toCharArray()) {
                        stack.push(c);
                    }
                    count--;
                }
            }
        }
        //把栈里面所有的字母取出来
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty())
            retv.insert(0, stack.pop());
        return retv.toString();
    }
}
