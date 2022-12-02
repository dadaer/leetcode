package backtracking;

import java.util.*;

/**
 * @source: leetcode491
 * @difficulty: medium
 * @topic: 递增子序列
 * @link: https://leetcode.cn/problems/increasing-subsequences/
 * @description: 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * @input: nums = [4,6,7,7]
 * @output: [4, 6], [4, 6, 7], [4, 6, 7, 7], [4, 7], [4, 7, 7], [6, 7], [6, 7, 7], [7, 7]
 * @requirements: 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class FindSubSequences {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4, 4, 3, 2, 1}));
    }

    static List<List<Integer>> res = new ArrayList<>();
    //路径集合
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums, 0);
        return res;
    }

    private static void getSubsequences(int[] nums, int start) {
        if (path.size() > 1 ) {
            res.add(new ArrayList<>(path));
            // 注意这里不要加return，要取树上的节点
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            // 使用过了当前数字
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            getSubsequences(nums, i + 1);
            path.removeLast();
        }
    }
}
