package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source: leetcode18
 * @difficulty: medium
 * @topic: 四数之和
 * @link: https://leetcode.cn/problems/4sum/
 * @description: 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * @input: nums = [1,0,-1,0,-2,2], target = 0
 * @output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * @requirements:
 */
public class FourSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // a 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // b 去重
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
