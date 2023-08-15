package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: leetcode763
 * @difficulty: medium
 * @topic: 划分字母区间
 * @link: https://leetcode.cn/problems/partition-labels/
 * @description: 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表
 * @input: "ababcbacadefegdehijhklij"
 * @output: [9,7,8]
 * @requirements:
 */
public class PartitionLabels_ {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbaca defegde hijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] ends = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ends[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ret = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, ends[s.charAt(i) - 'a']);
            if (i == end) {
                ret.add(end - start + 1);
                start = end + 1;
            }
        }
        return ret;
    }
}
