package string.medium;

import string.easy.AddStrings;

/**
 * @source: leetcode43
 * @difficulty: medium
 * @topic: 字符串相乘
 * @link: https://leetcode.cn/problems/multiply-strings/
 * @description: 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式
 * @input: num1 = "123", num2 = "456"
 * @output: "56088"
 * @requirements:
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply("9", "99"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            curr.append("0".repeat(Math.max(0, n - 1 - i)));
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = AddStrings.addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

}
