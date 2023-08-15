package string.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @source: leetcode71
 * @difficulty: medium
 * @topic: 简化路径
 * @link: https://leetcode.cn/problems/simplify-path/
 * @description: 给你一个字符串 path ，
 * 表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * @input: path = "/a/./b/../../c/"
 * @output: "/c"
 * @requirements:
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath1("/a//b////c/d//././/.."));
    }

    public static String simplifyPath1(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    public static String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = path.length();
        if (length == 1) {
            return path;
        }
        while (stringBuilder.length() > 1 && path.charAt(length - 1) == '/') {
            path = path.substring(0, length - 1);
            length--;
        }
        char c;
        stringBuilder.append('/');
        for (int i = 1; i < length; i++) {
            c = path.charAt(i);
            if (c == '.') {
                if (i < length - 2 && path.charAt(i + 1) == '.' && path.charAt(i + 2) != '/') {
                    while (i < length && path.charAt(i) != '/') {
                        stringBuilder.append(path.charAt(i));
                        i++;
                    }
                    i--;
                } else {
                    if (i != length - 1) {
                        if (path.charAt(i + 1) == '.') {
                            i = i + 2;
                            if (stringBuilder.length() != 1) {
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            }
                            while (stringBuilder.charAt(stringBuilder.length() - 1) != '/') {
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            }
                        } else {
                            if (path.charAt(i + 1) != '/') {
                                stringBuilder.append(c);
                            }
                        }
                    }
                }
            } else if (c == '/') {
                if (stringBuilder.charAt(stringBuilder.length() - 1) != '/') {
                    stringBuilder.append(c);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        while (stringBuilder.length() > 1 && stringBuilder.charAt(stringBuilder.length() - 1) == '/') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
