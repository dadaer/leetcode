package slidewindow;

/**
 * @source: leetcode1004
 * @difficulty: medium
 * @topic: 最大连续1的个数 III
 * @link: https://leetcode.cn/problems/max-consecutive-ones-iii/
 * @description: 给定一个二进制数组 nums 和一个整数 k，
 * 如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @input: nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * @output: 6
 * @explanation 愿数组修改成[1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
 * @requirements:
 */
public class LongestOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        int res = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            right++;
            while (count > k) { // 左边界需要收缩
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
