package array;

/**
 * @source: leetcode581
 * @difficulty: medium
 * @topic: 最短无序连续子数组
 * @link: https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 * @description: 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * @input: nums = [2,6,4,8,10,9,15]
 * @output: 5
 * @explanation 对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序
 * @requirements: 时间复杂度为 O(n)
 */
public class FindUnsortedSubarray_ {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }


//    从左到右找出最后一个破坏递增的数
//    从右到左找出最后一个破坏递减的数
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int high = 0, low = length - 1, curMax = Integer.MIN_VALUE, curMin = Integer.MAX_VALUE;
        // 一次 for 循环实现数组双向遍历
        for (int i = 0; i < length; i++) {
            if (nums[i] >= curMax) {
                curMax = nums[i];
            } else {
                high = i;
            }
            if (nums[length - i - 1] <= curMin) {
                curMin = nums[length - i - 1];
            } else {
                low = length - i - 1;
            }
        }
        return high > low ? high - low + 1 : 0;
    }
}
