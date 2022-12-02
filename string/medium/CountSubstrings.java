package string.medium;

/**
 * @source: leetcode647
 * @difficulty: medium
 * @topic: 回文子串
 * @link: https://leetcode.cn/problems/palindromic-substrings/
 * @description: 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * @input: s = "aaa"
 * @output: 6
 * @requirements:
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings1("abab"));
    }

    public static int countSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += substrings(s, i, i);
            if (i <= length - 2) {
                ans += substrings(s, i, i + 1);
            }
        }
        return ans;
    }

    private static int substrings(String s, int i, int j) {
        int sum = 0;
        int length = s.length();
        while (i >= 0 && j < length) {
            if (s.charAt(i) == s.charAt(j)) {
                sum++;
                i--;
                j++;
            } else {
                break;
            }
        }
        return sum;
    }


    public static int countSubstrings(String s) {
        int ans = 0;
        int oddCenterCount = 0;
        int evenCenterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            oddCenterCount = expandAroundCenter(s, i, i);
            evenCenterCount = expandAroundCenter(s, i, i + 1);
            ans += oddCenterCount + evenCenterCount;
        }
        return ans;
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            --left;
            ++right;
        }
        return count;
    }
}
