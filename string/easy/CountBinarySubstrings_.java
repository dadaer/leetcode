package string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: leetcode696
 * @difficulty: easy
 * @topic: 计数二进制子串
 * @link: https://leetcode.cn/problems/count-binary-substrings/
 * @description: 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * @input: s = "00110011"
 * @output: 6
 * @requirements:
 */
public class CountBinarySubstrings_ {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }

    public static int countBinarySubstrings(String s) {
        List<Integer> counts =  new ArrayList<>();
        int curCount = 1;
        int ans = 0;
        for (int i = 1; i < s.length() ; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curCount++;
            } else {
                counts.add(curCount);
                curCount = 1;
            }
        }
        counts.add(curCount);
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
