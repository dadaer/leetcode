package company.pinduoduo;

import java.util.*;

public class Ride {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] time = new int[n];
        int[] cost = new int[n];
        int[] timeReplace = new int[n];
        int[] costReplace = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
            cost[i] = scanner.nextInt();
            timeReplace[i] = scanner.nextInt();
            costReplace[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + cost[i - 1];
                if (j >= time[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - time[i - 1]] + cost[i - 1]);
                }
                if (j >= timeReplace[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - timeReplace[i - 1]] + costReplace[i - 1]);
                }
            }
        }
        if (dp[n][m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][m]);
        }
    }
}




