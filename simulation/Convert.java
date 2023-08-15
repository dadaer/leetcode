package simulation;

/**
 * @source: leetcode6
 * @difficulty: medium
 * @topic: Z 字形变换
 * @link: https://leetcode.cn/problems/zigzag-conversion/description/
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * @input: s = "PAYPALISHIRING", numRows = 3
 * @output: "PAHNAPLSIIGYIR"
 * @explanation
 * @requirements:
 */
public class Convert {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder[] chars = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            chars[i] = new StringBuilder();
        }
        int rowIndex = 0;
        for (int i = 0; i < length; i++) {
            while (i < length && rowIndex < numRows) {
                chars[rowIndex++].append(s.charAt(i++));
            }
            rowIndex--;
            while (i < length && rowIndex > 0) {
                chars[--rowIndex].append(s.charAt(i++));
            }
            rowIndex++;
            i--;
        }
        StringBuilder stringBuilder = new StringBuilder();
            for (StringBuilder c : chars) {
                stringBuilder.append(c);
            }
        return stringBuilder.toString();
    }
}
