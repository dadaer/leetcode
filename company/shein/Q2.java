package company.shein;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        int tokens = 100;
        int res = 0;
        int current = 0;

        for (int i = 0; i < lines; i++) {
            int time = sc.nextInt();
            int ac = sc.nextInt();
            tokens = Math.min(150, tokens + (time - current) / 100 * 10);
            if (ac > tokens) {
                res += ac - tokens;
                tokens = 0;
            } else {
                tokens -= ac;
            }
            current = time;
        }
        System.out.println(res);
    }
}
