package array.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @source: leetcode961
 * @difficulty: easy
 * @topic: 在长度 2N 的数组中找出重复 N 次的元素
 * @link: https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * @description: 给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * @input: nums = [1,2,3,3]
 * @output: 3
 * @requirements:
 */
public class RepeatedNTimes {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    // 舍弃一个元素就等同于众数问题
    public static int repeatedNTimes(int[] nums) {
        int ans = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length / 2) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
