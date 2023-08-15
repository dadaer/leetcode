package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @source: leetcode611
 * @difficulty: medium
 * @topic: 有效三角形的个数
 * @link: https://leetcode.cn/problems/valid-triangle-number/
 * @description: 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * @input: nums = [2,2,3,4]
 * @output: 3
 * @requirements:
 */
public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }

    public static int triangleNumber(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int k;
        int ans = 0;
        for (int i = 0; i < length; ++i) {
            k = i + 1; // 外循环对 k 赋值，相比于在内循环对 k 赋值，时间复杂度由 O(n^3) 降到 O(n^2)
            for (int j = i + 1; j < length; ++j) {
                while (k < length && nums[k] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - 1 - j, 0);
            }
        }
        return ans;
    }

    public static int triangleNumber1(int[] nums) {
        int res = 0;
        int length = nums.length;
        int left, right;
        Arrays.sort(nums);
        for (int i = length - 1; i >= 2; i--) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left++;
                } else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }
}
