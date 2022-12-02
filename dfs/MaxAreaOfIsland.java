package dfs;

/**
 * leetcode695
 * medium
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
