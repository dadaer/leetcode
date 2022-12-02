package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode78
 * @difficulty: medium
 * @topic: 子集
 * @link: https://leetcode.cn/problems/subsets/
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * @input: nums = [1,2,3]
 * @output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @requirements: 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> ret = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums, 0, path);
        return ret;
    }

    public static void backtracking(int[] nums, int startIndex, LinkedList<Integer> path) {
        if (!ret.contains(path)) {
            ret.add(new LinkedList<>(path));
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path);
            path.removeLast();
        }
    }
}
