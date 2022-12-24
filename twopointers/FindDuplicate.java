package twopointers;

/**
 * @source: leetcode287
 * @difficulty: medium
 * @topic: 寻找重复数
 * @link: https://leetcode.cn/problems/find-the-duplicate-number/description/
 * @description: 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * @input: nums = [1,3,4,2,2]
 * @output: 2
 * @requirements: 必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间
 */
public class FindDuplicate {
    public static void main(String[] args) {

    }

    // 快慢指针 寻找环入口
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
