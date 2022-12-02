package twopointers;

import java.util.List;

/*
    给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，
    该字符串可以通过删除 s 中的某些字符得到。
    如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class FindLongestWord {
    public static void main(String[] args) {

    }

    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    i++;
                }else {
                    i++;
                }
            }
            if (j == t.length()){
                if (t.length() > ans.length() || (t.length() == ans.length() && t.compareTo(ans) < 0)){
                    ans = t;
                }
            }
        }
        return ans;
    }
}
