package greedy;

/**
 * @source: leetcode55
 * @difficulty: medium
 * @topic: 跳跃游戏
 * @link: https://leetcode.cn/problems/jump-game/
 * @description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @input: nums = [2,3,1,1,4]
 * @output: true
 * @requirements:
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        int maxArrival = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxArrival >= nums.length - 1) {
                return true;
            }
            if (maxArrival >= i) {
                maxArrival = Math.max(maxArrival, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
