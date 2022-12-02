package array.easy;

/**
 * @source: leetcode169
 * @difficulty: easy
 * @topic: 多数元素
 * @link: https://leetcode.cn/problems/majority-element/
 * @description: 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @input: nums = [3,2,3]
 * @output: 3
 * @requirements:
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ans = nums[i];
                    count = 1;
                }
            }
        }
        return ans;
    }
}
