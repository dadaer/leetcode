package hard;

/**
 * @source: 剑指offer51
 * @difficulty: hard
 * @topic: 数组中的逆序对
 * @link: https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * @input: [7,5,6,4]
 * @output: 5
 * @requirements:
 */
public class ReversePairs {
    public static void main(String[] args) {
        reversePairs(new int[]{});
    }

    static int count;

    public static int reversePairs(int[] nums) {
        mergeSort(nums, 0 , nums.length - 1);
        return count;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // 对左侧子序列进行递归排序
        mergeSort(array, left, mid);
        // 对右侧子序列进行递归排序
        mergeSort(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入 temp 中
        while (p1 <= mid && p2 <= right) {
            if (array[p1] <= array[p2]) {
                temp[i++] = array[p1++];
            } else {
                count += mid - p1 + 1;
                temp[i++] =array[p2++];
            }
        }
        // 上面的循环退出后，把剩余的元素依次填入到 temp 中
        // 以下两个 while 只有一个会执行
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= right) {
            temp[i++] = array[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }
}
