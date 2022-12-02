package array.medium;

import java.util.Arrays;

/**
 * @source: leetcode75
 * @difficulty: medium
 * @topic: 颜色分类
 * @link: https://leetcode.cn/problems/sort-colors/
 * @description: 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @input: nums = [2,0,2,1,1,0]
 * @output: [0,0,1,1,2,2]
 * @requirements: 必须在不使用库的sort函数的情况下解决这个问题。
 */
public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        int pointer0 = 0;
        int pointer1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // Java是值传递，不能实现 swap 函数
                int temp = nums[pointer1];
                nums[pointer1] = nums[i];
                nums[i] = temp;
                pointer1++;
            } else if (nums[i] == 0) {
                int temp = nums[pointer0];
                nums[pointer0] = nums[i];
                nums[i] = temp;
                if (pointer0 < pointer1) {
                    temp = nums[pointer1];
                    nums[pointer1] = nums[i];
                    nums[i] = temp;
                }
                pointer0++;
                pointer1++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors1(int[] nums) {
        int length = nums.length;
        int p0 = 0, p2 = length - 1;
        for (int i = 0; i <= p2; ++i) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                ++p0;
            }
            if (nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2] = 2;
                --p2;
                if (nums[i] != 1) { // 指针回退
                    --i;
                }
            }
        }
    }
}
