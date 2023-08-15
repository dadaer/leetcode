package slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode438
 * @difficulty: medium
 * @topic: 找到字符串中所有字母异位词
 * @link: https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * @description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @input: s = "cbaebabacd", p = "abc"
 * @output: [0,6]
 * @requirements:
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams1("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return ans;
        }
        // 建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int[] scount = new int[26];
        int[] pcount = new int[26];
        // 当滑动窗口的首位在 s[0] 处时 （相当于放置滑动窗口进入数组）
        for (int i = 0; i < pLen; i++) {
            ++scount[s.charAt(i) - 'a']; // 记录 s 中前 pLen 个字母的词频
            ++pcount[p.charAt(i) - 'a']; // 记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }
        // 判断放置处是否有异位词  (在放置时只需判断一次)
        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }
        // 开始让窗口进行滑动
        for (int i = 0; i < sLen - pLen; i++) { // i 是滑动前的首位
            scount[s.charAt(i) - 'a']--;       // 将滑动前首位的词频删去
            scount[s.charAt(i + pLen) - 'a']++;  // 增加滑动后最后一位的词频（以此达到滑动的效果）
            //判断滑动后处，是否有异位词
            if (Arrays.equals(scount, pcount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return ret;
        }
        for (int i = pLength - 1; i < sLength; i++) {
            if (isAnagram(s, p, i)) {
                ret.add(i - pLength + 1);
            }
        }
        return ret;
    }

    private static boolean isAnagram(String s, String p, int i) {
        int length = p.length();
        String str = s.substring(i - length + 1, i + 1);
        int[] chars = new int[26];
        for (int j = 0; j < length; j++) {
            chars[p.charAt(j) - 'a']++;
        }
        for (int j = 0; j < length; j++) {
            chars[str.charAt(j) - 'a']--;
        }
        for (int aChar : chars) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }
}
