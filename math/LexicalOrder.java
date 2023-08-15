package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: leetcode386
 * @difficulty: medium
 * @topic: 字典序排数
 * @link: https://leetcode.cn/problems/lexicographical-numbers/
 * @description: 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * @input: n = 13
 * @output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
 * @explanation:
 * @requirements: 必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法
 */
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(lexicalOrder0(13));
    }

    // 空间复杂度O(1)
    public static List<Integer> lexicalOrder0(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    static List<Integer> res = new ArrayList<>();

    // 递归方法
    public static List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return res;
    }

    public static void dfs(int cur, int n) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i > n) {
                break;
            }
            dfs(cur * 10 + i, n);
        }
    }
}
