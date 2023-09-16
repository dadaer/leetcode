package company.meituan;

import java.util.*;

public class Neighbor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int x;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            map.put(x, i);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        if (Math.abs(map.get(a) - map.get(b)) <= 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
