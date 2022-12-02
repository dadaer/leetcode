package string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode409
 * @difficulty: easy
 * @topic: 最长回文串
 * @link: https://leetcode.cn/problems/longest-palindrome/
 * @description: 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * @input: s = "abccccdd"
 * @output: 7
 * @requirements:
 */
public class LongestPalindrome1 {
    public static void main(String[] args) {
        String s = "ddaaaacccf";
        System.out.println(longestPalindrome(s));
    }

    // 遇到有提示字符串仅包含小写（或者大写）英文字母的题，
    // 都可以试着考虑能不能构造长度为26的每个元素分别代表一个字母的数组，来简化计算
    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        System.out.println(s.toCharArray());
        for(char c : s.toCharArray()) {
            arr[c]++;
            System.out.println(arr[c]);
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

    public static int longestPalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean flag = false;
        int ans = 0;
        for (int i : map.values()) {
            if (i % 2 == 0) {
                ans += i;
            } else {
                flag = true;
                ans += (i - 1);
            }
        }
        return flag ? ans + 1: ans;
    }
}
