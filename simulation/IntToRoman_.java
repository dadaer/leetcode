package simulation;

/**
 * @source: leetcode12
 * @difficulty: medium
 * @topic: 证书转罗马
 * @link: https://leetcode.cn/problems/integer-to-roman/description/
 * @description: 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * @input: num = 58
 * @output: "LVIII"
 * @explanation: L = 50, V = 5, III = 3.
 * @requirements:
 */
public class IntToRoman_ {
    public static void main(String[] args) {

    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                stringBuilder.append(reps[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
