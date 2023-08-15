package meituan;

import java.util.*;

public class CycleRoad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int x;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            nums[i] = x;
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int c = Math.min(a , b);
        int d = Math.max(a , b);
        int solution1 = 0;
        int solution2 = 0;
        for (int i = c - 1; i < d - 1; i++) {
            solution1 += nums[i];
        }

        for (int i = 0; i < c - 1; i++) {
            solution2 += nums[i];
        }
        for (int i = d - 1; i < nums.length; i++) {
            solution2 += nums[i];
        }

        System.out.println(Math.min(solution1, solution2));

    }
}
