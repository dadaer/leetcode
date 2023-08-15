package slidewindow;

/**
 * @source: leetcode395
 * @difficulty: medium
 * @topic: 至少有 K 个重复字符的最长子串
 * @link: https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * @description: 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
 * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @input: s = "ababbc", k = 2
 * @output: 5
 * @explanation 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * @requirements:
 */
public class LongestSubstring {
    public static void main(String[] args) {

    }

    public static int longestSubstring(String s, int k) {
        int[] count = new int[26];
        int l = 0, r = 0, length = s.length();
        while (r < length) {
            count[s.charAt(r) - 'a']++;
            r++;


        }
        return 0;
    }
}
