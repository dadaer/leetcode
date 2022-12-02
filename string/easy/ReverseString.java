package string.easy;

/**
 * @source: leetcode541
 * @difficulty: easy
 * @topic: 反转字符串 II
 * @link: https://leetcode.cn/problems/reverse-string-ii/description/
 * @description: 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * @input: s = "abcdefg", k = 2
 * @output: "bacdfeg"
 * @requirements: 如果剩余字符少于 k 个，则将剩余字符全部反转。如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcde", 2));
    }

    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr); // 字符数组初始化String
    }

    public static String reverseStr1(String s, int k) {
        int curLength = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                if ((i + 1) - curLength >= k) {
                    reverse(chars, curLength, curLength + k - 1);
                } else {
                    reverse(chars, curLength, i);
                }
            } else {
                if ((i + 1) % (2 * k) == 0) {
                    reverse(chars, curLength, curLength + k - 1);
                    curLength += 2 * k;
                }
            }
        }
        return new String(chars);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
