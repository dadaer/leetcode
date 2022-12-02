package array.easy;

import java.util.Arrays;

/**
 * @source: leetcode977
 * @difficulty: easy
 * @topic: 有序数组的平方
 * @link: https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @description: 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @input: [-7, -3, 2, 3, 11]
 * @output: [4, 9, 9, 49, 121]
 * @requirements: 时间复杂度 O(n)
 */
public class SortedSquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int negative = 0;
        int index = 0;
        int length = nums.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }
        int i = negative;
        int j = negative + 1;
        while (i >= 0 || j < length) {
            if (i < 0) {
                ints[index++] = nums[j] * nums[j];
                j++;
            } else if (j == length) {
                ints[index++] = nums[i] * nums[i];
                i--;
            } else if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                ints[index++] = nums[i] * nums[i];
                i--;
            } else {
                ints[index++] = nums[j] * nums[j];
                j++;
            }
        }
        return ints;
    }
}
