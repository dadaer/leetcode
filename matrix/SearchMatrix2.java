package matrix;

/**
 * @source: leetcode240
 * @difficulty: medium
 * @topic: 搜索二维矩阵 II
 * @link: https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * @description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * @output: false
 * @requirements:
 */
public class SearchMatrix2 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        // 从右上角开始搜索，这样不同的方向可以增大或者减小 matrix[x][y]
        int x = 0, y = colLength - 1;
        while (x < rowLength && y > 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                ++x;
            } else {
                --y;
            }
        }
        return false;
    }
}
