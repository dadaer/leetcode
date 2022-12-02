package string.medium;

import java.util.*;

/**
 * @source: leetcode49
 * @difficulty: medium
 * @topic: 字母异位词分组
 * @link: https://leetcode.cn/problems/group-anagrams/
 * @description: 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * @input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * @output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @requirements:
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 转化成数组进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            // 可用字符数组初始化string
            String string = new String(chars);

            // 坑：
            // 在内容相同情况下，String 会 hash 得到相同的 key，
            // 由于 char[] 特殊机制，相同内容的在 hash 后值不会相同。数组根据地址哈希？
            // 因此Map中必须使用 String 作为 key
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str);
            map.put(string, list);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] ints = computeAnagramArray(str);
            boolean flag = false;
            for (int[] arr : map.keySet()) {
                if (Arrays.equals(ints, arr)) {
                    flag = true;
                    map.get(arr).add(str);
                }
            }
            if (!flag) {
                List<String> list = Arrays.asList(str);
                map.put(ints, new ArrayList<>(list));
            }
        }
        for(Map.Entry<int[], List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() != 0) {
                ret.add(entry.getValue());
            }
        }
        return ret;
    }

    private static int[] computeAnagramArray(String str) {
        int[] ints = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            ints[str.charAt(i) - 'a']++;
        }
        return ints;
    }
}
