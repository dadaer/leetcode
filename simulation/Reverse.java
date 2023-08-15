package simulation;

/**
 * @source: leetcode7
 * @difficulty: medium
 * @topic: 整数反转
 * @link: https://leetcode.cn/problems/reverse-integer/description/
 * @description: 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果
 * @input: x = -123
 * @output: -321
 * @explanation
 * @requirements: 不允许存储 64 位整数
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int res = 0;
        while(x != 0){

            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
