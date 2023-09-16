package company.shein;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] lines = input.split(",");
        String s = lines[0];
        int num = Integer.parseInt(lines[1]);
        System.out.println(convert(s, num));
    }

    public static String convert(String s, int num) {
        if (num == 1) return s;
        int n = Math.min(s.length(), num);
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            res[i] = "";
        }

        boolean flag = false;
        int loc = 0;

        for (int i = 0; i < s.length(); i++) {
            res[loc] += s.substring(i, i + 1);
            if (loc == 0 || loc == num - 1) {
                flag = !flag;
            }
            if (flag) {
                loc++;
            } else {
                loc--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String row : res) {
            ans.append(row);
        }
        return ans.toString();
    }
}
