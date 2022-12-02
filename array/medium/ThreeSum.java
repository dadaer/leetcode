package array.medium;

import java.util.*;

/**
 * @source: leetcode15
 * @difficulty: medium
 * @topic: 三数之和
 * @link: https://leetcode.cn/problems/3sum/
 * @description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 返回所有和为 0 且不重复的三元组。
 * @input: nums = [-1, 0, 1, 2, -1, -4]
 * @output: [[-1, -1, 2],[-1, 0, 1]]
 * @requirements:
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int j;
        int k;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = length - 1;
            while (j < k) {
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }

}
