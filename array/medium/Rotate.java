package array.medium;

/**
 * @source: leetcode189
 * @difficulty: medium
 * @topic: 轮转数组
 * @link: https://leetcode.cn/problems/rotate-array/description/
 * @description: 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @input: nums = [1,2,3,4,5,6,7], k = 3
 * @output: [5,6,7,1,2,3,4]
 * @requirements: 原地修改
 */
public class Rotate {
    public static void main(String[] args) {

    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length <= k) {
            k = k % length;
        }
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


}
