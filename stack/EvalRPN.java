package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @source: leetcode150
 * @difficulty: medium
 * @topic: 逆波兰表达式求值
 * @link: https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @description: 根据 逆波兰表示法，求表达式的值
 * @input: tokens = ["2","1","+","3","*"]
 * @output: 9
 * @requirements:
 */
public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                    default -> {
                    }
                }
            }
        }
        return stack.pop();
    }
    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
