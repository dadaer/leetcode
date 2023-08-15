package array.medium;

/**
 * @source: leetcode215
 * @difficulty: medium
 * @topic: 数组中的第K个最大元素
 * @link: https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * @description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @input: [3, 2, 1, 5, 6, 4], k = 2
 * @output: 5
 * @requirements: 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class FndKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
    }

    // 思路是快速排序采用的partition
    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        if (pivot == k - 1) {
            return nums[pivot];
        } else {
            if (pivot < k - 1) {
                return quickSelect(nums, pivot + 1, high, k);
            } else {
                return quickSelect(nums, low, pivot - 1, k);
            }
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int i = low, j = high;
        int pivot = nums[i];
        while (i < j) {
            while (nums[j] < pivot && i < j) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (nums[i] > pivot && i < j) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }

    // ------------------------------------------------
    // 小顶堆
    public static int findKthLargest2(int[] nums, int k) {
        buildMinHeap(nums, k);
        for (int i = k; i < nums.length; i++) { // ! 注意这里循环内必须用 nums.length, 不能用 heapSize. 因为 heapSize 一直在变化
            //
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                minHeapify(nums, 0, k);
            }
        }
        return nums[0];
    }

    public static void buildMinHeap(int[] a, int heapSize) {
        // 从最后一个父节点位置开始调整每一个节点的子树。数组长度为 heasize，因此最后一个节点的位置为 heapsize - 1，所以父节点的位置为 (heapsize - 1 - 1) / 2。
        for (int i = (heapSize - 2) / 2; i >= 0; --i) {
            minHeapify(a, i, heapSize);
        }
    }

    public static void minHeapify(int[] a, int i, int heapSize) {      //调整当前结点和子节点的顺序。
        // left 和 right 表示当前父节点i的两个左右子节点。
        int left = i * 2 + 1, right = i * 2 + 2, smaller = i;
        // 如果左子点在数组内，且比当前父节点大，则将最大值的指针指向左子点。
        if (left < heapSize && a[left] < a[smaller]) {
            smaller = left;
        }
        // 如果右子点在数组内，且比当前父节点大，则将最大值的指针指向右子点。
        if (right < heapSize && a[right] < a[smaller]) {
            smaller = right;
        }
        // 如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if (smaller != i) {
            swap(a, i, smaller);
            // 由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            minHeapify(a, smaller, heapSize);
        }
    }

    // 大顶堆
    public static int findKthLargest1(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 建堆完毕后， nums[0] 为最大元素。逐个删除堆顶元素，直到删除了 k - 1 个。
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) { // ! 注意这里循环内必须用 nums.length, 不能用 heapSize. 因为 heapSize 一直在变化

            // 先将堆的最后一个元素与堆顶元素交换，由于此时堆的性质被破坏，需对此时的根节点进行向下调整操作。
            swap(nums, 0, i);
            // 相当于删除堆顶元素，此时长度变为 nums.length - 2。即下次循环的i
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        // 从最后一个父节点位置开始调整每一个节点的子树。数组长度为 heasize，因此最后一个节点的位置为 heapsize - 1，所以父节点的位置为 (heapsize - 1 - 1) / 2。
        for (int i = (heapSize - 2) / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {      //调整当前结点和子节点的顺序。
        // left 和 right 表示当前父节点i的两个左右子节点。
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        // 如果左子点在数组内，且比当前父节点大，则将最大值的指针指向左子点。
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        // 如果右子点在数组内，且比当前父节点大，则将最大值的指针指向右子点。
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        // 如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if (largest != i) {
            swap(a, i, largest);
            // 由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
