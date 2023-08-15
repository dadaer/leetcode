package hard;

/**
 * @source: leetcode41
 * @difficulty: hard
 * @topic: 缺失的第一个正数
 * @link: https://leetcode.cn/problems/first-missing-positive/description/
 * @description: https://leetcode.cn/problems/first-missing-positive/description/
 * @input: nums = [3,4,-1,1]
 * @output: 2
 * @requirements: 实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    // 哈希方法


    // 置换
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
