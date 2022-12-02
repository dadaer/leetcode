package binarysearch;

/**
 * leetcode540
 * medium
 * 有序数组中的单一元素
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {

    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low= mid + 1;
                } else {
                    high = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}
