package array.easy;

import javax.crypto.Mac;

/**
 * @source: leetcode485
 * @difficulty: easy
 * @topic: 最大连续 1 的个数
 * @link: https://leetcode.cn/problems/max-consecutive-ones/
 * @description: 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * @input: nums = [1,1,0,1,1,1]
 * @output: 3
 * @requirements:
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count, maxCount);
        return maxCount;
    }
}
