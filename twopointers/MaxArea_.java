package twopointers;

/**
 * @source: leetcode11
 * @difficulty: medium
 * @topic: 盛最多水的容器
 * @link: https://leetcode.cn/problems/container-with-most-water/
 * @description: 给定一个长度为 n 的整数数组 height 。
 * 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量
 * @input: [1,8,6,2,5,4,8,3,7]
 * @output: 49
 * @requirements:
 */
public class MaxArea_ {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }
        return maxArea;
    }
}
