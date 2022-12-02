package string.medium;

/**
 * @source: leetcode8
 * @difficulty: medium
 * @topic: 字符串转换整数 (atoi)
 * @link: https://leetcode.cn/problems/string-to-integer-atoi/
 * @description:
 * @input: s = "   -42"
 * @output: -42
 * @requirements:
 */
public class MyAtoi_ {

    public static void main(String[] args) {
        System.out.println(myAtoi1(".14526"));
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        while (i < m && s.charAt(i) == ' ') {
            i++;
        }
        int start = i;
        for (; i < m; i++) {
            char c = s.charAt(i);
            if (i == start && c == '+') {
                sign = 1;
            } else if (i == start && c == '-') { // 只有在首位的时候才有效
                sign = -1;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                // 判断当前的数是否大于 int 最大值或小于 int 最小值
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {
                break;
            }
        }
        return res;
    }

    public static int myAtoi1(String s) {
        int len = s.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = s.toCharArray();
        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }
        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }
        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
