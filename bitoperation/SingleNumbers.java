package bitoperation;

/**
 * @source: 剑指offer56 - I
 * @difficulty: medium
 * @topic: 数组中数字出现的次数
 * @link: https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/description/
 * @description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @input: nums = [4,1,4,6]
 * @output: [1,6] 或 [6,1]
 * @requirements: 设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 */
public class SingleNumbers {
    public static void main(String[] args) {

    }

    public static int[] singleNumbers(int[] nums) {
        // 因为相同的数字异或为 0，任何数字与 0 异或结果是其本身。
        // 所以遍历异或整个数组最后得到的结果就是两个只出现一次的数字异或的结果：即 z = x ^ y
        int z = 0;
        for (int i : nums) {
            z ^= i;
        }
        // 我们根据异或的性质可以知道：z 中至少有一位是 1，否则 x 与 y 就是相等的。
        // 我们通过一个辅助变量 m 来保存 z 中哪一位为 1.（可能有多个位都为 1，我们找到最低位的 1 即可）。
        // 举个例子：z = 10 ^ 2 = 1010 ^ 0010 = 1000,第四位为 1.
        // 我们将 m 初始化为 1，如果（z & m）的结果等于 0 说明z的最低为是 0
        // 我们每次将 m 左移一位然后跟 z 做与操作，直到结果不为 0.
        // 此时 m 应该等于 1000，同 z 一样，第四位为 1.
        int m = 1;
        while ((z & m) == 0) {
            m <<= 1;
        }
        // 我们遍历数组，将每个数跟 m 进行与操作，结果为 0 的作为一组，结果不为 0 的作为一组
        // 例如对于数组：[1,2,10,4,1,4,3,3]，我们把每个数字跟 1000 做与操作，可以分为下面两组：
        // nums1 存放结果为 0 的: [1, 2, 4, 1, 4, 3, 3]
        // nums2 存放结果不为 0 的: [10] (碰巧 nums2 中只有一个 10，如果原数组中的数字再大一些就不会这样了)
        // 此时我们发现问题已经退化为数组中有一个数字只出现了一次
        // 分别对 nums1 和 nums2 遍历异或就能得到我们预期的 x 和 y
        int x = 0, y = 0;
        for (int i : nums) {
            // 这里我们是通过 if...else 将 nums 分为了两组，一边遍历一边异或。
            // 跟我们创建俩数组 nums1 和 nums2 原理是一样的。
            if ((i & m) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[]{x, y};
    }

    public static int[] singleNumbers1(int[] nums) {
        int eor = 0;
        for (int i : nums) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1); // 取得 eor 最右边的 1
        int eor1 = 0;
        for (int j : nums) {
            if ((j & rightOne) == rightOne) {
                eor1 ^= j;
            }
        }
        return new int[]{eor1, eor ^ eor1};
    }
}
