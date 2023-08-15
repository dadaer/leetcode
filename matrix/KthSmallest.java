package matrix;

/**
 * @source: leetcode378
 * @difficulty: medium
 * @topic: 有序矩阵中第 K 小的元素
 * @link: https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * @description: 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * @input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * @output: 13
 * @explanation: 矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * @requirements: 必须找到一个内存复杂度优于 O(n2) 的解决方案
 */
public class KthSmallest {
    public static void main(String[] args) {

    }

    /**
     * 关于二分查找返回的left一定在矩阵中这个问题, 写一点个人的理解.
     *
     * 我们先看check函数.check函数的目的是统计矩阵里小等于mid的元素数目count.
     * 再判断count和k的关系.因为mid = (l + r) / 2这种划分方法是把矩阵划分成了[left , mid] 与[mid + 1, right]两部分.
     * 当 count < k 时, 说明mid太小了, 我们应该在[mid + 1, right] 这个范围里查找. 否则在[left, mid]范围里查找.
     * 如果存在一个不在矩阵中的数a满足条件, 因为a不在矩阵中,那count统计的元素肯定都是小于a的,
     * 那一定存在一个比a小且在矩阵中的数b满足条件,即从小于a的数变成了小于等于b的数 .
     * 等用题目中的例子,x = 13 和x = 14 都满足小于等于x的元素数目等于8,
     * 对14来说统计的都是小于它的数, 而对13来说统计的都是小于等于它的数.
     * 问题来了, 那为何取到的不是14而是13呢?
     *
     * 因为我们取mid的取法是 mid = (left + right) / 2, 当left < right时, mid 永远 取不到right, 想
     * 要mid取到right ,只有left == right. 但循环条件是 while(left < right),
     * 当 left == right时循环已经终止. 所以我们得到会是一个左边界.
     * 还是用题目中的例子, 假设left = 13, right = 14 则 mid = (13 + 14) / 2 = 13
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
