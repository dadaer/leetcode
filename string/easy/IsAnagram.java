package string.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @source: leetcode242
 * @difficulty: easy
 * @topic: 有效的字母异位词
 * @link: https://leetcode.cn/problems/valid-anagram/
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @input: s = "anagram", t = "nagaram"
 * @output: true
 * @requirements:
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ab","a"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (record[t.charAt(i) - 'a'] > 0) {
                record[t.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
