package array.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @source: leetcode442
 * @difficulty: medium
 * @topic: 数组中重复的数据
 * @link: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * @description: 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
 * 且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * @input: nums = [4,3,2,7,8,2,3,1]
 * @output: [2,3]
 * @requirements: 必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        int temp;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    set.add(nums[i]);
                    break;
                }
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        return set.stream().toList();
    }
}
