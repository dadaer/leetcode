package matrix;

import java.util.Arrays;

/**
 * @source: leetcode498
 * @difficulty: medium
 * @topic: 对角线遍历
 * @link: https://leetcode.cn/problems/diagonal-traverse/
 * @description: 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * @input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * @output: [1,2,4,7,5,3,6,8,9]
 * @requirements:
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        int r = 0, c = 0;
        int row = mat.length, col = mat[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往下移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往右移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往下移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public static int[] findDiagonalOrder1(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int newLength = rowLength * colLength;
        int[] res = new int[newLength];
        int index = 0;
        int i = 0, j = 0;
        while (index < newLength) {
            while (i >= 0 && j < colLength) {
                res[index++] = mat[i][j];
                i--;
                j++;
            }
            if (j == colLength) { // 先做这一步判断
                j = colLength - 1;
                i += 2;
            }
            if (i < 0) {
                i = 0;
            }
            while (j >= 0 && i < rowLength) {
                res[index++] = mat[i][j];
                i++;
                j--;
            }
            if (i == rowLength) {
                i = rowLength - 1;
                j += 2;
            }
            if (j < 0) {
                j = 0;
            }
        }
        return res;
    }
}
