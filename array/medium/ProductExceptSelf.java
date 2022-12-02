package array.medium;

import java.util.Arrays;

/**
 * @source: leetcode238
 * @difficulty: medium
 * @topic: 除自身以外数组的乘积
 * @link: https://leetcode.cn/problems/product-of-array-except-self/
 * @description: 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * @input: nums = [1,2,3,4]
 * @output: [24,12,8,6]
 * @requirements: 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ret = new int[length];
        ret[0] = 1;
        for (int i = 1; i < length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            ret[i] *= R;
            R *= nums[i];
        }
        return ret;
    }
}
