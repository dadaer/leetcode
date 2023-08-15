package slidewindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @source: leetcode567
 * @difficulty: medium
 * @topic: 字符串的排列
 * @link: https://leetcode.cn/problems/permutation-in-string/description/
 * @description: 给你两个字符串 s1 和 s2 ，
 * 写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * @input: s1 = "ab" s2 = "eidbaooo"
 * @output: true
 * @explanation: s2 包含 s1 的排列之一 ("ba").
 * @requirements:
 */
public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion0("ab", "eidbaooo"));
    }

    // labuladong 滑动窗口模板
    public static boolean checkInclusion0(String s1, String s2) {
        // 滑动窗口,包含的情况下：至少有一个窗口只包含s1中的全部字符，并且该窗口每个字符的个数与s1中每个字符的个数相等
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0; // 窗口：左闭右开
        int valid = 0;  // 窗口中满足s1要求的字符个数
        while (right < s2.length()) {
            char c = s2.charAt(right);
            ++right; // 扩大窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { // 字符c满足s1的要求
                    valid++;
                }
            }
            // 求排列，说明窗口[left, right)中字符数量和目标字符数量一样，所以窗口最大为s1.length()
            if (right - left == s1.length()) {  // 到达最大窗口，开始收缩窗口
                if (valid == need.size()) { // 窗口中元素是s1的一个排列
                    return true;
                }
                // 收缩窗口
                char d = s2.charAt(left);
                ++left;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) { // 下一步d的个数-1后就不满足了，有效元素-1
                        valid--;
                    }
                    window.put(d, window.get(d) - 1); // 字符d在窗口中的个数-1
                }
            }
        }
        return false;
    }

    // 解法和 438 题一样
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
