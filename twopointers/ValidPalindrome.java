package twopointers;

/**
 * @source: leetcode680
 * @difficulty: easy
 * @topic: 验证回文串 II
 * @link: https://leetcode.cn/problems/valid-palindrome-ii/
 * @description: 给你一个字符串 s，最多 可以从中删除一个字符。请你判断 s 是否能成为回文字符串
 * @input: s = "abca"
 * @output: true
 * @requirements:
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    // 官方答案
    public static boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome1(String s) {
        boolean deleted = false;
        int index1 = 0, index2 = s.length() - 1;
        while (index1 <= index2) {
            if (s.charAt(index1) == s.charAt(index2)) {
                index1++;
                index2--;
            } else {
                System.out.println(s.charAt(index1));
                System.out.println(s.charAt(index2));
                if (deleted == true) {
                    return false;
                } else {
                    deleted = true;
                    if (s.charAt(index1 + 1) == s.charAt(index2)) {
                        index1++;
                    } else if(s.charAt(index1) == s.charAt(index2 - 1)) {
                        index2--;
                    } else {
                        index1++;
                    }
                }
            }
        }
        return true;
    }
}
