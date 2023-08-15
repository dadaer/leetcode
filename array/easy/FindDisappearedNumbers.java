package array.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode448
 * @difficulty: easy
 * @topic: 找到所有数组中消失的数字
 * @link: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * @description: 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n]
 * 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @input: nums = [4,3,2,7,8,2,3,1]
 * @output: [5,6]
 * @requirements: 不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    // 不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题
    public static List<Integer> findDisappearedNumbers0(int[] nums) {
        int length = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret  = new LinkedList<>();
        int length = nums.length;
        int[] helper = new int[length + 1];
        for (int num : nums) {
            helper[num] = num;
        }
        for (int i = 1; i < length + 1; i++) {
            if (helper[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
