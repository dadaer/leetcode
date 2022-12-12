package string.easy;

/**
 * @source: leetcode415
 * @difficulty: easy
 * @topic: 字符串相加
 * @link: https://leetcode.cn/problems/add-strings/
 * @description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * @input: num1 = "11", num2 = "123"
 * @output: "134"
 * @requirements: 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        int i = length1 - 1;
        int j = length2 - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.insert(0, sum);
            i--;
            j--;
        }
        if (carry == 1) {
            ans.insert(0, 1);
        }
        return ans.toString();
    }
}
