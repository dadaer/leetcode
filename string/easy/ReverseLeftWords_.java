package string.easy;

/**
 * @source: 剑指offer58-II
 * @difficulty: easy
 * @topic: 左旋转字符串
 * @link: https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @input: s = "abcdefg", k = 2
 * @output: "cdefgab"
 * @requirements: 原地修改
 */
public class ReverseLeftWords_ {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        int length = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, length - 1);
        reverse(chars, 0, length - 1);
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
