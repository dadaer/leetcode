package array.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode34
 * @difficulty: medium
 * @topic: 在排序数组中查找元素的第一个和最后一个位置
 * @link: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @description: 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @input: nums = [5,7,7,8,8,10], target = 8
 * @output: [3, 4]
 * @requirements: 必须设计并实现时间复杂度为 O(log n) 的算法解决此问题
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    //找 >= target 的第一个元素的下标
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
