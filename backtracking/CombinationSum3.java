package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode216
 * @difficulty: medium
 * @topic: 组合总和3
 * @link: https://leetcode.cn/problems/combination-sum-iii/description/
 * @description: 找出所有相加之和为 n 的 k 个数的组合，且满足 I)只使用数字1到9 II)每个数字最多使用一次,
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * @input: k = 3, n = 7
 * @output: [[1,2,4]]
 * @requirements:
 */
public class CombinationSum3 {
    private static List<List<Integer>> ret = new LinkedList<>();
    private static int sum;

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(k, n, 1, path);
        return ret;
    }

    private static void backtracking(int k, int n, int startIndex, LinkedList<Integer> path) {
        if (sum > n || path.size() > k) {
            return;
        }
        if (sum == n && path.size() == k) {
            ret.add(new LinkedList<>(path));
            return;
        }
        for(int i = startIndex; i <= n; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, i + 1, path);
            path.removeLast();
            sum -= i;
        }
    }

}
