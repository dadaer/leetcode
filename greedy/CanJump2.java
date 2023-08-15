package greedy;

import java.util.Arrays;
/**
 * @source: leetcode45
 * @difficulty: medium
 * @topic: 跳跃游戏II
 * @link: https://leetcode.cn/problems/jump-game-ii/
 * @description: 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]
 * @input: nums = [2,3,1,1,4]
 * @output: 2
 * @explanation: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * @requirements:
 */
public class CanJump2 {
    public static void main(String[] args) {
        System.out.println(canJump0(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    // 贪心
    public static int canJump0(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end)
            {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

    // 讨论区动态规划的解法
    public static int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        int bestStartIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            while (i > bestStartIndex + nums[bestStartIndex]) {
                bestStartIndex++;
            }
            dp[i] = dp[bestStartIndex] + 1;
        }
        return dp[nums.length - 1];
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        // 初始化
        Arrays.fill(dp, length);
        dp[0] = 0;


        // 递推
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[length -1];
    }
}
