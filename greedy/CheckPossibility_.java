package greedy;

/**
 * @source: leetcode665
 * @difficulty: medium
 * @topic: 非递减数列
 * @link: https://leetcode.cn/problems/non-decreasing-array/
 * @description: 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * @input: nums = [4,2,3]
 * @output: true
 * @requirements:
 */
public class CheckPossibility_ {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        boolean flag = nums[0] <= nums[1]; // 标识是否还能修改
        // 遍历时，每次需要看连续的三个元素
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) { // 出现递减
                if (flag) {  // 如果还有修改机会，进行修改
                    if (nums[i + 1] >= nums[i - 1]) { // 修改方案1
                        nums[i] = nums[i + 1];
                    } else {                          // 修改方案2
                        nums[i + 1] = nums[i];
                    }
                    flag = false;                     // 用掉唯一的修改机会
                } else { // 没有修改机会，直接结束
                    return false;
                }
            }
        }
        return true;
    }
}
