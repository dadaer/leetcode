package bitoperation;

/**
 * @source: leetcode461
 * @difficulty: easy
 * @topic: 汉明距离
 * @link: https://leetcode.cn/problems/hamming-distance/description/
 * @description: 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目
 * @input:  x = 1, y = 4
 * @output: 2
 * @requirements:
 */
public class HammingDistance {
    public static void main(String[] args) {

    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        if (x == y)
            return 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x / 2;
            y = y / 2;
        }
        return count;
    }
}
