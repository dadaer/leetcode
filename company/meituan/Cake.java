package company.meituan;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] nums = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        int topSum = 0;
        int bottomSum = 0;
        int cutCol = 1;
        int cutRow = 1;
        while (cutCol < cols) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cutCol; j++) {
                    leftSum += nums[i][j];
                }
                for (int j = cutCol; j < cols; j++) {
                    rightSum += nums[i][j];
                }
            }
            ans = Math.min(ans, Math.abs(leftSum - rightSum));
            leftSum = 0;
            rightSum = 0;
            cutCol++;
        }

        while (cutRow < rows) {
            for (int i = 0; i < cutRow; i++) {
                for (int j = 0; j < cols; j++) {
                    topSum += nums[i][j];
                }
            }
            for (int i = cutRow; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    bottomSum += nums[i][j];
                }
            }
            ans = Math.min(ans, Math.abs(topSum - bottomSum));
            topSum = 0;
            bottomSum = 0;
            cutRow++;
        }
        System.out.println(ans);
    }
}
