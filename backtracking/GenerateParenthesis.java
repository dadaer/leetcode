package backtracking;

import java.util.*;

/**
 * leetcode22
 * medium
 * 括号生成
 * 括号生成 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> ret= new LinkedList<>();

    //所有的可能性->回溯
    public static List<String> generateParenthesis(int n) {
        char[] parenthesis = new char[]{'(', ')'};
        StringBuilder sb = new StringBuilder();
        backtracking("",0,0,3);
        return ret;
    }

    // 类似于二叉树的遍历
    public static void backtracking(String path,int left, int right, int n) {
        if (left > n || right > left) {
            return;
        }
        if (path.length() == 2 * n) {
            ret.add(path);
            return;
        }
        backtracking(path + "(", left + 1, right, n);
        backtracking(path + ")", left, right + 1, n);
    }

    public static void backtracking1(char[] parenthesis,int n, StringBuilder sb) {
        if (sb.length() > 2 * n ) {
            return;
        }
        if (sb.length() == 2 * n && isValid(sb)) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (sb.length() > 0 && sb.charAt(0) == ')') {
                break;
            }
            sb.append(parenthesis[i]);
            backtracking1(parenthesis, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isValid(StringBuilder s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
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
