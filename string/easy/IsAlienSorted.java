package string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode953
 * @difficulty: easy
 * @topic: 验证外星语词典
 * @link: https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * @description: 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * @input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * @output: true
 * @requirements:
 */
public class IsAlienSorted {
    public static void main(String[] args) {
        String[] words = new String[]{"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) { // 防止数组越界
            for (int j = 0; j < words[i].length(); j++) {
                if (j == words[i + 1].length()) { // apple app
                    return false;
                }
                int a = map.get(words[i].charAt(j)), b = map.get(words[i + 1].charAt(j));
                if (a > b) {
                    return false;
                } else if (a < b) {
                    break;
                }
            }
        }
        return true;
    }
}
