package string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode205
 * @difficulty: easy
 * @topic: 同构字符串
 * @link: https://leetcode.cn/problems/isomorphic-strings/
 * @description: 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * @input: s = "egg", t = "add"
 * @output: true
 * @requirements:
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("add","egg"));
    }

    // 秀儿 indexOf 最前索引比较
    public static boolean isIsomorphic(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    // hashmap
    public static boolean isIsomorphic1(String s, String t) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            char temp1 = t.charAt(i);
            if (!map.containsKey(temp)) {
                if(map.containsValue(temp1)) {
                    return false;
                }
                map.put(temp,temp1);
            } else if (map.get(temp) != temp1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int length = t.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
            if (map.containsValue(s.charAt(i)) && !map.containsKey(t.charAt(i))) {
                return false;
            }
            map.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

}
