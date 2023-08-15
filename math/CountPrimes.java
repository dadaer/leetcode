package math;

import java.util.Arrays;

/**
 * @source: leetcode204
 * @difficulty: medium
 * @topic: 计数质数
 * @link: https://leetcode.cn/problems/count-primes/description/
 * @description: 给定整数 n ，返回 所有小于非负整数 n 的质数的数量
 * @input: n = 10
 * @output: 4
 * @explanation: 2、3、5、7
 * @requirements:
 */
public class CountPrimes {
    public static void main(String[] args) {

    }

    // 数学 埃氏筛
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return ans;
    }
}
