package company.meituan;

import java.util.*;

public class Islands {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String line = in.next();
        int charIndex = 0;
        int index = 2;
        int ans = 0;
        while (index < n) {
            if (n % index == 0) {
                int cols = n / index;
                char[][] chars = new char[index][cols];
                for (int i = 0; i < index; i++) {
                    for (int j = 0; j < cols; j++) {
                        chars[i][j] = line.charAt(charIndex);
                        charIndex++;
                    }
                }
                for (int i = 0; i < index; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (chars[i][j] != '0') {
                            ans += numIslands(chars, chars[i][j]);
                        }
                    }
                }
            }
            index++;
        }
        System.out.println(ans);
    }

    public static int numIslands(char[][] grid, char c) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == c) {
                    ans++;
                    dfs(grid, i, j, rowLength, colLength, c);
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] nums, int i, int j, int M, int N, char c) {
        if(i < 0 || i > M - 1 || j < 0 || j > N - 1 || nums[i][j] != c) {
            return;
        }
        nums[i][j] = '0';
        dfs(nums, i + 1, j, M, N, c);
        dfs(nums, i - 1, j, M, N, c);
        dfs(nums, i, j + 1, M, N, c);
        dfs(nums, i, j - 1, M, N, c);
    }
}
