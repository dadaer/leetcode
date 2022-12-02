package matrix;

/**
 * leetcode240
 * medium
 * 搜索二维矩阵Ⅱ
 */
public class SearchMatrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        // 从右上角开始搜索，这样不同的方向可以增大或者减小matrix[x][y]
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
