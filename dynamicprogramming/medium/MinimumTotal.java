package dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source: leetcode120
 * @difficulty: medium
 * @topic: 三角形最小路径和
 * @link: https://leetcode.cn/problems/triangle/description/
 * @description: 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * @input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * @output: 11
 * @requirements:
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(list));
    }

    private static int res = Integer.MAX_VALUE;

    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        dfs(triangle, 0, 0, sum);
        return res;
    }

    // 回溯超时
    private static void dfs(List<List<Integer>> triangle, int col, int index, int sum) {
        if (index == triangle.size()) {
            if (sum < res) {
                res = sum;
            }
            return;
        }
        for (int i = 0; i < triangle.get(index).size(); i++) {
            if (i == col || i == col + 1) {
                sum += triangle.get(index).get(i);
                dfs(triangle, i, index + 1, sum);
                sum -= triangle.get(index).get(i);
            }
        }
    }

    // 动态规划
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // 初始化
        dp[0][0] = triangle.get(0).get(0);

        // 递推
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            res = Math.min(dp[n - 1][i], res);
        }
        return res;
    }
}
