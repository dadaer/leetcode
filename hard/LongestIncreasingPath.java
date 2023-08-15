package hard;

import java.util.Map;

/**
 * @source: leetcode329
 * @difficulty: hard
 * @topic: 矩阵中的最长递增路径
 * @link: https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/
 * @description: 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 你不能在对角线方向上移动或移动到 边界外（即不允许环绕）
 * @input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * @output: 4
 * @requirements:
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        // [3,4,5],[3,2,6],[2,2,1]
        int[][] a = {{3,4,5},{3,2,6},{2,2,1}};
        longestIncreasingPath1(a);
    }

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        memo[row][column] = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }

    static int maxLen = 0;

    public static int longestIncreasingPath1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];//计算以每个节点开头的递增序列的长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, m, n, visited, Integer.MIN_VALUE));
            }
        }
        return maxLen;
    }

    public static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] visited, int pre) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= pre) {
            return 0;
        }
        if (visited[i][j] > 0) {
            return visited[i][j]; // 如果之前已经计算过，直接返回即可
        }
        int l = dfs(matrix, i - 1, j, m, n, visited, matrix[i][j]);
        int r = dfs(matrix, i + 1, j, m, n, visited, matrix[i][j]);
        int up = dfs(matrix, i, j - 1, m, n, visited, matrix[i][j]);
        int down = dfs(matrix, i, j + 1, m, n, visited, matrix[i][j]);
        visited[i][j] = 1 + Math.max(Math.max(l, r), Math.max(up, down));
        return visited[i][j];
    }
}
