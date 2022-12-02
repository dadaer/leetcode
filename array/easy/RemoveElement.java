package array.easy;

/**
 * @source: leetcode27
 * @difficulty: easy
 * @topic: 移除元素
 * @link: https://leetcode.cn/problems/remove-element/
 * @description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @input: nums = [3,2,2,3], val = 3
 * @output: 2, nums = [2,2]
 * @requirements: 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
