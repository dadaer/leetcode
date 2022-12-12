package binarysearch;

/**
 * @source: 剑指offer11
 * @difficulty: easy
 * @topic: 旋转数组的最小数字
 * @link: https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/description/
 * @description: 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * @input: numbers = [3,4,5,1,2]
 * @output: 1
 * @requirements:
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
