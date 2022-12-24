package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode594
 * @difficulty: easy
 * @topic: 最长和谐子序列
 * @link: https://leetcode.cn/problems/longest-harmonious-subsequence/
 * @description: 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * @input: nums = [1,3,2,2,5,2,3,7]
 * @output: 5
 * @requirements:
 */
public class FindLHS {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,1,1,1}));
    }

    // 哈希表方法
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                maxLength = Math.max(map.get(i) + map.get(i + 1), maxLength);
            }
        }
        return maxLength;
    }

    // 排序＋双指针方法
    public static int findLHS0(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if ( nums[j] - nums[i] <= 1) {
                j++;
            } else {
                i++;
            }
            if (j < nums.length && nums[j] - nums[i] == 1  ) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}
