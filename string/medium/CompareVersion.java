package string.medium;

/**
 * @source: leetcode165
 * @difficulty: medium
 * @topic: 比较版本号
 * @link: https://leetcode.cn/problems/compare-version-numbers/
 * @description: 给你两个版本号 version1 和 version2 ，请你比较它们。
 * @input: version1 = "1.01", version2 = "1.001"
 * @output: 0
 * @requirements:
 */
public class CompareVersion {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.00.1", "1.0.2"));
    }

    public static int compareVersion(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int i = 0;
        int j = 0;
        int x;
        int y;
        while (i < length1 || j < length2) {
            x = 0;
            while (i < length1 && version1.charAt(i) != '.') {
                x = x * 10 + version1.charAt(i) - '0';
                i++;
            }
            i++; // 跳过点号
            y = 0;
            while (j < length2 && version2.charAt(j) != '.') {
                y = y * 10 + version2.charAt(j) - '0';
                j++;
            }
            j++; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
