package company.pinduoduo;

import java.util.Scanner;

public class XArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a * n + 1 > b || n == 1 && a != b) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}



