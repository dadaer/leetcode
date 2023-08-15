package array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode974
 * @difficulty: medium
 * @topic: 和可被 K 整除的子数组
 * @link: https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 * @description: 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * 子数组 是数组的 连续 部分。
 * @input: nums = [4,5,0,-2,-3,1], k = 5
 * @output: 7
 * @explanation: 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * @requirements:
 */
public class SubArraysDivByK {
    public static void main(String[] args) {
        System.out.println(subArraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    // 同 560 题
    // 子数组 前缀和
    public static int subArraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 不能忘记
        int ans = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            int m = (prefixSum % k + k) % k; // 注意负数
            if (map.containsKey(m)) {
                ans += map.get(m);
            }
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        return ans;
    }

    // 数组时间击败 100%
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        int len = nums.length;
        int[] map = new int[k];
        map[0] = 1;
        for (int num : nums) {
            sum = sum + num;
            int key = (sum % k + k) % k;
            res += map[key];
            map[key]++;
        }
        return res;
    }
}
