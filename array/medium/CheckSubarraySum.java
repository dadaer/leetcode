package array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @source: leetcode523
 * @difficulty: medium
 * @topic: 连续的子数组和
 * @link: https://leetcode.cn/problems/continuous-subarray-sum/
 * @description: 给你一个整数数组 nums 和一个整数 k ，
 * 编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * @input: nums = [23,2,4,6,7], k = 6
 * @output: true
 * @explanation: [23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * @requirements:
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }

    // 同 525 题
    // 子数组 前缀和
    public static boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int prefix = 0;
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            prefix += nums[i];
            remainder = prefix % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else { // 这里用 else，可以保证存的下标最小，子数组长度最长
                map.put(remainder, i);
            }
        }
        return false;
    }
}
