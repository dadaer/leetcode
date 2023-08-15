package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode46
 * @difficulty: medium
 * @topic: 全排列
 * @link: https://leetcode.cn/problems/permutations/
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @input: nums = [1,2,3]
 * @output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @requirements:
 */
public class Permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> ret = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums, used, path);
        return ret;
    }

    public static void backtracking(int[] nums, boolean[] used, LinkedList<Integer> path) {
        if (nums.length == path.size()) {
            // 这里要存放 path 的拷贝，存放 path 的话只存放了引用，会跟着变空
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used, path);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
