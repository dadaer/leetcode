package dfs;

/**
 * leetcode200
 * medium
 * 岛屿数量
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'1', '1', '1', '1', '0',},
                {'1', '1', '0', '1', '0',},
                {'1', '1', '0', '0', '0',},
                {'0', '0', '0', '0', '0',},
        };
        System.out.println(numIslands(chars));
    }

    public static int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, rowLength, colLength);
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] nums, int i, int j, int M, int N) {
        if(i < 0 || i > M - 1 || j < 0 || j > N - 1 || nums[i][j] != '1') {
            return;
        }
        nums[i][j] = '2';
        dfs(nums, i + 1, j, M, N);
        dfs(nums, i - 1, j, M, N);
        dfs(nums, i, j + 1, M, N);
        dfs(nums, i, j - 1, M, N);
    }
}
