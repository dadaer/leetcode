package array.medium;

/**
 * @source: leetcode33
 * @difficulty: medium
 * @topic: 搜索旋转排序数组
 * @link: https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * @input: nums = [4,5,6,7,0,1,2], target = 0
 * @output: 4
 * @requirements:
 */
public class SearchRotateSortedArray_ {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3}, 3));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) { //左半边有序
                if (nums[l] <= target && target < nums[mid]) { // target 值在 nums[0] 到 nums[mid] 之间
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { //右半边有序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
