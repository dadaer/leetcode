package string.easy;

/**
 * @source: leetcode459
 * @difficulty: easy
 * @topic: 重复的子字符串
 * @link: https://leetcode.cn/problems/repeated-substring-pattern/
 * @description: 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * @input: s = "abab"
 * @output: true
 * @requirements:
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
    }

    // 暴力
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            String ss = s.substring(0, i + 1);
            if (s.length() % (i + 1) != 0) { // 不能整除 跳过
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (ss.charAt(j % (i + 1)) != s.charAt(j)) {
                    break;
                }
                if (j == s.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 移动匹配
    public static boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
