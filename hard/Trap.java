package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @source: leetcode42
 * @difficulty: hard
 * @topic: 接雨水
 * @link: https://leetcode.cn/problems/trapping-rain-water/description/
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * @input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * @output: 6
 * @requirements:
 */
public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // 动态规划

    // 单调栈
    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
