package bitoperation;

/**
 * @source: leetcode136
 * @difficulty: easy
 * @topic: 只出现一次的数字
 * @link: https://leetcode.cn/problems/single-number/
 * @description: 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * @input: nums = [2,2,1]
 * @output: 1
 * @requirements: 设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2}));
    }

    // 异或运算
    // 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a。
    // 任何数和其自身做异或运算，结果是 0，即 a ^ a = 0。
    // 异或运算满足交换律和结合律
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}
