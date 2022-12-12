package binarysearch;

/**
 * @source: leetcode162
 * @difficulty: medium
 * @topic: 寻找峰值
 * @link: https://leetcode.cn/problems/find-peak-element/
 * @description: 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * @input: nums = [1,2,3,1]
 * @output: 2
 * @requirements: 时间复杂度为 O(log n)
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] ints = {1,2};
        System.out.println(findPeakElement(ints));
    }

    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        return findPeakElement(nums, left, right, length);
    }

    private static int findPeakElement(int[] nums, int left, int right, int length) {
        int middle = left + (right - left) / 2;
        if ((middle == 0 || nums[middle] > nums[middle - 1]) && (middle == length - 1 || nums[middle] > nums[middle + 1])) {
            return middle;
        }
        if (left == right) {
            return -1;
        }
        return findPeakElement(nums, left, middle, length) != -1 ? findPeakElement(nums, left, middle, length)
                : findPeakElement(nums, middle + 1, right, length);
    }

    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
