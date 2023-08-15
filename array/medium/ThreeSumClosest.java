package array.medium;

import java.util.Arrays;

/**
 * @source: leetcode16
 * @difficulty: medium
 * @topic: 最接近的三数之和
 * @link: https://leetcode.cn/problems/3sum-closest/
 * @description: 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * @input: nums = [-1,2,1,-4], target = 1
 * @output: 2
 * @requirements:
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int j;
        int k;
        int sum;
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closestNum - target)) {
                    closestNum = sum;
                }
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }
        return closestNum;
    }
}
