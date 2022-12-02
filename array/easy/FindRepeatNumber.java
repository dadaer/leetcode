package array.easy;

/**
 * @source: 剑指offer3
 * @difficulty: easy
 * @topic: 数组中重复的数字
 * @link: https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @description: 找出数组中重复的数字。
 * @input: [2, 3, 1, 0, 2, 5, 3]
 * @output: 2 或 3
 * @requirements:
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    // 经典错误：nums[nums[i]] = nums[i], 这里 nums[i] 在上一步已经做了修改
                    nums[temp] = temp;
                }
            }
        }
        return 0;
    }
}
