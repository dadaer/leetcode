package string.easy;

import java.util.Map;

/**
 * @source: leetcode14
 * @difficulty: easy
 * @topic: 最长公共前缀
 * @link: https://leetcode.cn/problems/longest-common-prefix/
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @input: strs = ["flower","flow","flight"]
 * @output: "fl"
 * @requirements:
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int length = strs.length;
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        for (int j = 0; j < length; j++) {
            minLength = Math.min(minLength, strs[j].length());
        }
        while (i < minLength) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) != c) {
                    return ans.length() == 0 ? "" :ans.toString();
                }
            }
            ans.append(c);
            i++;
        }
        return ans.toString();
    }
}
