package matrix;

/**
 * @source: leetcode74
 * @difficulty: medium
 * @topic: 搜索二维矩阵
 * @link: https://leetcode.cn/problems/search-a-2d-matrix/
 * @description: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * @output: true
 * @requirements:
 */
public class SearchMatrix1 {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int x = 0;
        int y = 0;
        while (x < rowLength) {
            if (matrix[x][y] ==  target) {
                return true;
            } else if (matrix[x][y] < target) {
                ++y;
                if (y == colLength) {
                    x++;
                    y = 0;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    // 看成一维数组
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (right >= left){
            int mid = left + (right - left) / 2;
            int midRow = mid / matrix[0].length;
            int midCol = mid % matrix[0].length;
            if(matrix[midRow][midCol] > target){
                right = mid - 1;
            }else if(matrix[midRow][midCol] < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }


    // 两次二分，时间复杂度O(logmn)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
