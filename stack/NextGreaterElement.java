package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @source: leetcode496
 * @difficulty: easy
 * @topic: 下一个更大元素 I
 * @link: https://leetcode.cn/problems/next-greater-element-i/
 * @description:
 * @input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * @output: [-1,3,-1]
 * @requirements:
 */
public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums1.length;
        int[] res = new int[length];

        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
