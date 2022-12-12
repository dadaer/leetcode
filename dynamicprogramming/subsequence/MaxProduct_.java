package dynamicprogramming.subsequence;

/**
 * @source: leetcode152
 * @difficulty: medium
 * @topic: 乘积最大子数组
 * @link: https://leetcode.cn/problems/maximum-product-subarray/description/
 * @description: 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @input: nums = [2,3,-2,4]
 * @output: 6
 * @requirements: 
 */
public class MaxProduct_ {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,3,-4}));

    }

    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int mx, mn;
        for (int i = 1; i < nums.length; ++i) {
            mx = maxF;
            mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
