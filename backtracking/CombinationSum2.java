package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode40
 * @difficulty: medium
 * @topic: 组合总和2
 * @link: https://leetcode.cn/problems/combination-sum-ii/
 * @description: 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * @input: candidates = [10,1,2,7,6,1,5], target = 8
 * @output: [[1,1,6],[1,2,5],[1,7],[2,6]]
 * @requirements: candidates 中的每个数字在每个组合中只能使用 一次, 解集不能包含重复的组合
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,1,7,6,1,5}, 8));
    }

    public static List<List<Integer>> ret = new LinkedList<>();
    static int sum;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(candidates,0, target, path);
        return ret;
    }

    public static void backtracking(int[] nums, int startIndex, int target, LinkedList<Integer> path) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // 这里要存放 path 的拷贝，存放 path 的话只存放了引用，会跟着变空
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            sum += nums[i];
            backtracking(nums, i + 1, target, path);
            sum -= nums[i];
            path.removeLast();
        }
    }
}
