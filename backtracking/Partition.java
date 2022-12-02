package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode131
 * @difficulty: medium
 * @topic: 分割回文串
 * @link: https://leetcode.cn/problems/palindrome-partitioning/
 * @description: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * @input: s = "aab"
 * @output: [["a","a","b"],["aa","b"]]
 * @requirements:
 */
public class Partition {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(partition("aab"));
    }

    private static List<List<String>> ret = new ArrayList<>();
    private static LinkedList<String> path = new LinkedList<>();

    public static List<List<String>> partition(String s) {
        backtracking(s, 0);
        return ret;
    }

    private static void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
