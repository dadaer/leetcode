package recite;

/**
 * @source: leetcode31
 * @difficulty: medium
 * @topic: 下一个排列
 * @link: https://leetcode.cn/problems/next-permutation/description/
 * @description: 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * @input: nums = [1,2,3]
 * @output: [1,3,2]
 * @requirements: 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
