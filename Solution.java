import design.LRUCache;
import linkedList.ListNode;
import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    public static void solve(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 1; i < rowLength - 1; i++) {
            for (int j = 1; j < colLength - 1; j++) {
                if (board[i][i] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'X') {
            return;
        }
        board[x][y] = 'X';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
