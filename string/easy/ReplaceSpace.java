package string.easy;

/**
 * @source: 剑指offer05
 * @difficulty: easy
 * @topic: 替换空格
 * @link: https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * @description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @input: "We are happy."
 * @output: "We%20are%20happy."
 * @requirements:
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
      int count = 0;
      int length = s.length();
      for (int i = 0; i < length; i++) {
          if (s.charAt(i) == ' ') {
              count++;
          }
      }
      int newLength = length + 2 * count;
      char[] chars = new char[newLength];
      int j = length - 1;
      int k = newLength - 1;
      while (j < k) {
          if (s.charAt(j) == ' ') {
              chars[k] = '0';
              chars[--k] = '2';
              chars[--k] = '%';
          } else {
              chars[k] = s.charAt(j);
          }
          k--;
          j--;
      }
        for (int i = 0; i <= k; i++) {
            chars[i] = s.charAt(i);
        }
      return new String(chars);
    }
}
