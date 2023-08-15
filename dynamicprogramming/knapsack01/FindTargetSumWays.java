package dynamicprogramming.knapsack01;

/**
 * @source: leetcode494
 * @difficulty: medium
 * @topic: 目标和
 * @link: https://leetcode.cn/problems/target-sum/
 * @description:
 * @input: nums = [1,1,1,1,1], target = 3
 * @output: 5
 * @requirements:
 */
public class FindTargetSumWays {
    public static void main(String[] args) {

    }

    static int count = 0;

    // 回溯法
    public static int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public static void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    // 动态规划
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 绝对值范围超过了 sum 的绝对值范围则无法得到
        if (Math.abs(target) > Math.abs(sum)) return 0;
        int len = nums.length;
        int range = sum * 2 + 1; // 因为要包含负数所以要两倍，又要加上 0 这个中间的那个情况
        int[][] dp = new int[len][range]; // 这个数组是从总和为 -sum 开始的
        // 加上 sum 纯粹是因为下标界限问题，赋第二维的值的时候都要加上 sum
        // 初始化 第一个数只能分别组成 + -nums[i] 的一种情况
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if ((j + nums[i]) > sum) { // + 不成立 加上当前数大于了 sum 只能减去当前的数
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum];
                } else if ((j - nums[i]) < -sum)  { // - 不成立  减去当前数小于 -sum 只能加上当前的数
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum];
                } else { // + - 都可以
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum] + dp[i - 1][j - nums[i] + sum];
                }
            }
        }
        return dp[len - 1][sum + target];
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[size];
    }
}
