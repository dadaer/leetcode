package company.pinduoduo;

import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] B = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    B[i][j] = scanner.nextInt();
                }
            }

            int[][] A = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int maxRow = B[i][j];
                    for (int k = 0; k < M; k++) {
                        maxRow = Math.max(maxRow, B[i][k]);
                    }
                    int maxCol = B[i][j];
                    for (int k = 0; k < N; k++) {
                        maxCol = Math.max(maxCol, B[k][j]);
                    }
                    if (B[i][j] == maxRow && B[i][j] == maxCol) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }

            boolean isValid = true;
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int maxRow = A[i][j];
                    for (int k = 0; k < M; k++) {
                        maxRow = Math.max(maxRow, A[i][k]);
                    }
                    int maxCol = A[i][j];
                    for (int k = 0; k < N; k++) {
                        maxCol = Math.max(maxCol, A[k][j]);
                    }
                    if (A[i][j] != maxRow || A[i][j] != maxCol) {
                        isValid = false;
                        break;
                    }
                    if (A[i][j] == 1) {
                        count++;
                    }
                }
                if (!isValid) {
                    break;
                }
            }

            if (isValid) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }
    }
}


