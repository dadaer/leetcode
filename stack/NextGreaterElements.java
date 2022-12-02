package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @source: leetcode503
 * @difficulty: medium
 * @topic: 下一个更大元素 II
 * @link: https://leetcode.cn/problems/next-greater-element-ii/
 * @description: 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），
 * 返回nums中每个元素的 下一个更大元素 。
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * @input: nums = [1,2,1]
 * @output: [2,-1,2]
 * @requirements:
 */
public class NextGreaterElements {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        // 处理循环数组的一个思想：遍历完数组以后再遍历一遍前 n - 1 个元素
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.empty() && nums[i % nums.length ] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
