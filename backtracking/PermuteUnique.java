package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode47
 * @difficulty: medium
 * @topic: 全排列II
 * @link: https://leetcode.cn/problems/permutations-ii/
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @input: nums = [1,1,2]
 * @output: [[1, 1, 2],[1, 2, 1],[2 ,1, 1]]
 * @requirements:
 */
public class PermuteUnique {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 1}));
    }

    private static List<List<Integer>> ret = new LinkedList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used, path);
        return ret;
    }

    private static void backtracking(int[] nums, boolean[] used, LinkedList<Integer> path) {
        if (nums.length == path.size()) {
            // 这里要存放 path 的拷贝，存放 path 的话只存放了引用，会跟着变空
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // && !used[i - 1] 重要
                continue;
            }
            // 如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                used[i] = true;// 标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backtracking(nums, used, path);
                path.remove(path.size() - 1);// 回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }
}
