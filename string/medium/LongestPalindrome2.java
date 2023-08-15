package string.medium;

/**
 * @source: leetcode5
 * @difficulty: medium
 * @topic: 最长回文子串
 * @link: https://leetcode.cn/problems/longest-palindromic-substring/
 * @description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * @input: s = "babad"
 * @output: "bab"
 * @requirements:
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    // 中心扩散法
    public static String longestPalindrome(String s) {
        int max = 0, cur = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddCount = expandAroundCenter(s, i, i);
            int evenCount = expandAroundCenter(s, i, i + 1);
            cur = Math.max(oddCount, evenCount);
            if (cur > max) {
                max = cur;
                start = i - (cur - 1) / 2;
                end = i + cur / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static String longestPalindrome1(String s) {
        int max = 0, cur = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expandAroundCenter1(s, i, i);
            int evenLength = expandAroundCenter1(s, i, i + 1);
            cur = Math.max(oddLength, evenLength);
            if (cur > max) {
                max = cur;
                start = i - (cur - 1) / 2;
                end = i + cur / 2;
            }
        }
        return s.substring(start, end);
    }

    public static int expandAroundCenter1(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
