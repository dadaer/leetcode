package twopointers;

/**
 * leetcode11
 * medium
 * 盛最多水的容器
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
