package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode39
 * @difficulty: medium
 * @topic: 组合总和
 * @link: https://leetcode.cn/problems/combination-sum/
 * @description: 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * @input: candidates = [2,3,6,7], target = 7
 * @output: [[2,2,3],[7]]
 * @requirements:
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> ret = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(candidates,0, target, path);
        return ret;
    }

    public static void backtracking(int[] nums, int startIndex, int target, LinkedList<Integer> path) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // 这里要存放 path 的拷贝，存放 path 的话只存放了引用，会跟着变空
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i, target, path);
            path.removeLast();
        }
    }

}
