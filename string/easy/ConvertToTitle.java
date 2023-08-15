package string.easy;

/**
 * @source: leetcode169
 * @difficulty: easy
 * @topic: Excel表列名称
 * @link: https://leetcode.cn/problems/excel-sheet-column-title/
 * @description: 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称
 * @input: columnNumber = 701
 * @output: ZY
 * @requirements:
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            stringBuilder.insert(0, (char) ('A' + (columnNumber - 1) % 26));
            if (columnNumber % 26 == 0) {
                columnNumber--;
            }
            columnNumber /= 26;
        }
        return stringBuilder.toString();
    }

    // 26 进制问题
    public static String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; // 先减 1
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
