package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode94
 * @difficulty: medium
 * @topic: 复原IP地址
 * @link: https://leetcode.cn/problems/restore-ip-addresses/
 * @description:
 * @input: s = "25525511135"
 * @output: ["255.255.11.135","255.255.111.35"]
 * @requirements:
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses1("0000"));
    }

    private static List<String> ret = new ArrayList<>();
    int length;

    // 最好理解的方法
    public List<String> restoreIpAddresses2(String s) {
        length = s.length();
        LinkedList<String> path = new LinkedList<>();
        backtracking(s, 0, path);
        return ret;
    }

    private void backtracking(String s, int index, LinkedList<String> path) {
        if (path.size() > 4) {
            return;
        }
        if (path.size() == 4 && index == length) {
            ret.add(toResult(path));
            return;
        }

        for (int i = index; i < length; i++) {
            if (!isValid(s, index, i)) {
                return;
            }
            String s1 = s.substring(index, i + 1);
            path.add(s1);
            backtracking(s, i + 1, path);
            path.removeLast();
        }
    }

    public String toResult(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static List<String> restoreIpAddresses1(String s) {
        backtracking(s, 0, 0);
        return ret;
    }

    private static void backtracking(String s, int startIndex, int dotNumber) {
        if (dotNumber == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                ret.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                dotNumber++;
                backtracking(s, i + 2, dotNumber);
                dotNumber--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private static boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, s, "", 0, 0);
        return ans;
    }

    public static void backtrack(List<String> list, String s, String str, int p, int idx) {
        // 执行到最后一个字符，且加了三个点
        if (p == 4 && idx == s.length()) {
            list.add(str);
            return;
        }
        // 剪枝，当剩余字符串长度 大于 剩余ip地址需要的最大长度（表示剩余字符串必有多余）
        if ((4 - p) * 3 < s.length() - idx) return;
        int sum = 0;
        for (int i = idx; i < s.length(); i++) {
            // 前导0
            if (s.charAt(idx) == '0' && idx < i) break;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum >= 0 && sum <= 255) {
                backtrack(list, s, str + sum + (p == 3 ? "" : "."), p + 1, i + 1);
            } else {
                return;
            }
        }
    }
}
