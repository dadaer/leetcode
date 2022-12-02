package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @source: leetcode202
 * @difficulty: easy
 * @topic: 快乐数
 * @link: https://leetcode.cn/problems/happy-number/
 * @description: 编写一个算法来判断一个数 n 是不是快乐数。
 * @input: n = 19
 * @output: true
 * @requirements:
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
