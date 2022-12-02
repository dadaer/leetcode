package array.medium;

/**
 * @source: leetcode209
 * @difficulty: medium
 * @topic: 长度最小的子数组
 * @link: https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @description: 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @input: target = 7, nums = [2, 3, 1, 2, 4, 3]
 * @output: 2
 * @requirements: 时间复杂度 O(n)
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int subSum = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < length) {
            sum += nums[right];
            while (sum - subSum >= target) {
                ans = Math.min(right - left + 1, ans);
                subSum += nums[left++];
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int length = nums.length;
        int subArraySum = nums[end];
        while (start <= end) {
            if (subArraySum < target) {
                end++;
                if (end == length) {
                    break;
                }
                subArraySum += nums[end];
            } else {
                ans = Math.min(ans, end - start + 1);
                subArraySum -= nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
