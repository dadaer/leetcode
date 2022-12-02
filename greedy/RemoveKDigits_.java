package greedy;

/**
 * @source: leetcode402
 * @difficulty: medium
 * @topic: 移掉 K 位数字
 * @link: https://leetcode.cn/problems/remove-k-digits/
 * @description: 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * @input: num = "1432219", k = 3
 * @output: "1219"
 * @requirements:
 */
public class RemoveKDigits_ {
    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }
    //贪心
    public static String removeKdigits(String num, int k) {
            int length = num.length();
            if (length == k) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : num.toCharArray()) {
                while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > ch) {
                    // 每移掉一位数，k--
                    sb.deleteCharAt(sb.length() - 1);
                    k--;
                }
                if (ch == '0' && sb.length() == 0) {
                    continue;
                }
                sb.append(ch);
            }
            //
            String res = sb.substring(0, Math.max(sb.length() - k, 0));
            return res.length() == 0 ? "0" : res;
    }
    
    // 最后一个测试用例超时
    public static String removeKdigits1(String num, int k) {
        int length = num.length();
        if (length == k) {
            return "0";
        }
        int step = length - k;
        StringBuilder sb = new StringBuilder();
        int min_pos = -1;
        while (step > 0) {
            int start = min_pos + 1;
            char min_val = num.charAt(start);
            for (int i = length - step; i >= start; i--) {
                if (num.charAt(i) <= min_val) {
                    min_val = num.charAt(i);
                    min_pos = i;
                }
            }
            if (min_val == '0' && sb.length() == 0) {
                step--;
            } else {
                sb.append(min_val);
                step--;
            }
        }
        return sb.toString().equals("")  ? "0" : sb.toString();
    }
}
