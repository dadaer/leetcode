package string.medium;

/**
 * @source: leetcode151
 * @difficulty: medium
 * @topic: 反转字符串中的单词
 * @link: https://leetcode.cn/problems/reverse-words-in-a-string/
 * @description: 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * @input: "  hello world  "
 * @output: "world hello"
 * @requirements: 输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class ReverseWords {

    //不使用Java内置方法实现
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  the"));
    }

    //1.去除首尾以及中间多余空格
    //2.反转整个字符串
    //3.反转各个单词
    public static String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        // 双指针
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 若sb的最后一个字母不是空格，则可以添加一个空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }


    //反转字符串指定区间[start, end]的字符
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
