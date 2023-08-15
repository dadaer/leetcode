package array.medium;

import java.util.*;

/**
 * @source: leetcode525
 * @difficulty: medium
 * @topic: 连续数组
 * @link: https://leetcode.cn/problems/contiguous-array/description/
 * @description: 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 * @input: nums = [1, 0, 1, 0]
 * @output: 4
 * @explanation:
 * @requirements:
 */
public class FindMaxLength {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,1,0,0,0}));
    }

    // 前缀和 + HashMap
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int counter = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 求个数就存个数，哨兵存（0，1） 求长度就存下标，哨兵存（0，-1）
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else { // 这里用 else，可以保证存的下标最小，子数组长度最长
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
