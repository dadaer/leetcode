package stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @source: leetcode394
 * @difficulty: medium
 * @topic: 字符串解码
 * @link: https://leetcode.cn/problems/decode-string/
 * @description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * @input: s = "3[a]2[bc]"
 * @output: "aaabcbc"
 * @requirements:
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
                int count = Integer.parseInt(sb1.toString());
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

    public static String decodeString1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){ // 截取数字
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--; // 前移 1 位
                numStack.push(num);
            } else if (ch == '[' || Character.isLetter(ch)) {
                strStack.push(String.valueOf(ch));
            } else {
                StringBuilder stringBuilder1 = new StringBuilder();
                while (!Objects.equals(strStack.peek(), "[")) {
                    stringBuilder1.insert(0, strStack.pop());
                }
                strStack.pop(); // 移除 "["
                stringBuilder1.append(String.valueOf(stringBuilder1).repeat(numStack.pop() - 1));
                strStack.push(stringBuilder1.toString());
            }
        }
        while (!strStack.isEmpty()) {
            stringBuilder.insert(0, strStack.pop());
        }
        return stringBuilder.toString();
    }
}
