package array.easy;

/**
 * @source: leetcode268
 * @difficulty: easy
 * @topic: 丢失的数字
 * @link: https://leetcode.cn/problems/missing-number/description/
 * @description: 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @input: nums = [3,0,1]
 * @output: 2
 * @requirements: 实现线性时间复杂度、仅使用额外常数空间的算法解决此问题
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{3, 1, 0}));
    }

    // 数学方法 求和
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        return total - arrSum;
    }

    // 下标对应
    public static int missingNumber1(int[] nums) {
        // 先扫描一遍
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == 0) {
                break;
            }
            i++;
        }
        if (i == length) {
            return 0;
        }
        int temp;
        for (int j = 0; j < length; j++) {
            if (nums[j] != 0) {
                while (nums[j] != j + 1) {
                    temp = nums[j];
                    nums[j] = nums[nums[j] - 1];
                    nums[temp - 1] = temp;
                    if (nums[j] == 0) {
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < length; j++) {
            if (nums[j] == 0) {
                return j + 1;
            }
        }
        return -1;
    }
}
