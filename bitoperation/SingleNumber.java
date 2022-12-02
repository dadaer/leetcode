package bitoperation;

/**
 * leetcode136* easy
 * 只出现一次的数字
 * 线性时间复杂度，不使用额外空间
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2}));
    }

    // 异或运算
    // 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a。
    // 任何数和其自身做异或运算，结果是 0，即 a ^ a =0。
    // 异或运算满足交换律和结合律
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
