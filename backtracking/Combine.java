package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode77
 * @difficulty: medium
 * @topic: 组合
 * @link: https://leetcode.cn/problems/combinations/
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * @input: n = 4, k = 2
 * @output: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 * @requirements:
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> ret = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(n, k, 1, path);
        return ret;
    }

    public static void backtracking(int n, int k, int startIndex, LinkedList<Integer> path) {
        if (path.size() == k) {
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, startIndex + 1, path);
            path.removeLast();
        }
    }
}
