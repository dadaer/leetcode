package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source: leetcode283
 * @difficulty: easy
 * @topic: 移动零
 * @link: https://leetcode.cn/problems/move-zeroes/
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @input: nums = [0,1,0,3,12]
 * @output: [1,3,12,0,0]
 * @requirements: 必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeros {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    public static int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
