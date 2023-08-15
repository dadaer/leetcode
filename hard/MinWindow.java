package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @source: leetcode76
 * @difficulty: hard
 * @topic: 最小覆盖子串
 * @link: https://leetcode.cn/problems/minimum-window-substring/description/
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @input: s = "ADOBECODEBANC", t = "ABC"
 * @output: "BANC"
 * @requirements:
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }

    public static String minWindow(String s, String t) {
        int length = s.length();
        int left = 0, right = 0, start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < length) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid += need.get(c);
                }
            }
            right++;

            while (valid == t.length()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                if (need.containsKey(c1)) {
                    if (Objects.equals(need.get(c1), window.get(c1))) {
                        valid -= window.get(c1);
                    }
                    window.put(c1, window.get(c1) - 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
