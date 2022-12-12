package dfs;

/**
 * @source: 剑指offer13
 * @difficulty: medium
 * @topic: 机器人的运动范围
 * @link: https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @description:
 * @input:
 * @output:
 * @requirements:
 */
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 2));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    public static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || j >= n || k < getSum(i) + getSum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    public static int getSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
