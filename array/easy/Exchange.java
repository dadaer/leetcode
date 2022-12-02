package array.easy;

import java.util.Arrays;

/**
 * @source: 剑指offer21
 * @difficulty: easy
 * @topic: 调整数组顺序使奇数位于偶数前面
 * @link: https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * @input: nums = [1,2,3,4]
 * @output: [1,3,2,4]
 * @requirements:
 */
public class Exchange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 1 && left < right) { // 注意 left++ 以后的越界
                left++;
            }
            while (nums[right] % 2 == 0 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
