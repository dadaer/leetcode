package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode17
 * @difficulty: medium
 * @topic: 电话号码的字母组合
 * @link: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @input: digits = "23"
 * @output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @requirements:
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("456"));
    }

    private static List<String> ret = new LinkedList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ret;
        }
        String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int length = digits.length();
        int[] indexs = new int[length];
        for (int i = 0; i < length; i++) {
            indexs[i] = digits.charAt(i) - '2';
        }
        StringBuilder path = new StringBuilder();
        backtracking(strings, path, 0, indexs);
        return ret;
    }

    public static void backtracking(String[] strings, StringBuilder path, int index, int[] indexs) {
        int length = indexs.length;
        if (path.length() == length) {
            ret.add(path.toString());
            return;
        }

//        for (int i = m; i < length; i++) {
//            for (int k = 0; k < strings[indexs[i]].length(); k++) {
//                path.append(strings[indexs[i]].charAt(k));
//                backtracking(strings, path, i + 1, indexs);
//                path.deleteCharAt(path.length() - 1);
//            }
//        }

        for (int i = 0; i < strings[indexs[index]].length(); i++) {
            path.append(strings[indexs[index]].charAt(i));
            backtracking(strings, path, index + 1, indexs);
            path.deleteCharAt(path.length() - 1);
        }
    }




}
