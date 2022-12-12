package design;

/**
 * @source: leetcode69
 * @difficulty: easy
 * @topic: x 的平方根
 * @link: https://leetcode.cn/problems/sqrtx/
 * @description: 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * @input: x = 4
 * @output: 2
 * @requirements:
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(12));
    }

    public static int mySqrt(int x) {
        int i = 1; // 注意 x = 0 的情况
        int j = x;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid > x / mid) { // 防止越界
                j = mid - 1;
            } else if (mid < x / mid){
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return i - 1;
    }
}
