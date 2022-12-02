package binarysearch;

/**
 * 剑指offer11
 * easy
 * 旋转数组的最小数字
 */
public class MinArray {
    public static void main(String[] args) {

    }

    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 和最右边元素进行比较
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if ( numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
