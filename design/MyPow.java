package design;

/**
 * @source: 剑指offer16
 * @difficulty: medium
 * @topic: 数值的整数次方
 * @link: https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @input: x = 2.00000, n = 10
 * @output: 1024.00000
 * @explanation:
 * @requirements:
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static double myPow1(double x, int n) {
        long a = n;
        // 由于递归里判断的是 a % 2 == 0
        // 也可 return a >= 0 ? quickMul(x, a) : 1.0 / quickMul(x, a);
        return a >= 0 ? quickMul(x, a) : 1.0 / quickMul(x, -a);
    }
    public static double quickMul(double x, long a) {
        if (a == 0) {
            return 1.0;
        }
        double y = quickMul(x, a / 2);
        return a % 2 == 0 ? y * y : y * y * x;
    }
}
