package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @source: leetcode128
 * @difficulty: medium
 * @topic: 最长连续序列
 * @link: https://leetcode.cn/problems/longest-consecutive-sequence/
 * @description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * @input: nums = [100,4,200,1,3,2]
 * @output: 4
 * @requirements: 设计并实现时间复杂度为 O(n) 的算法解决此问题
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        int count = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return ans;
    }
}
