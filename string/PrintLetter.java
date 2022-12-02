package string;

import java.util.LinkedList;
import java.util.List;

public class PrintLetter {
    public static void main(String[] args) {
        f(28, 7);
    }

    public static void f(int a, int b) {
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < b; i++) {
            list.add(new StringBuilder());
        }
        int curCol = 0;
        char i = 'A';
        while (i < 'A' + a) {
            if (curCol % 2 == 0) {
                for (int j = 0; j < b; j++) {
                    if (i > 'Z') {
                        i = 'A';
                        a = a - 26;
                    }
                    if (i < 'A' + a) {
                        list.get(j).append(i++);
                    }
                }
            } else {
                for (int j = b - 1; j >= 0; j--) {
                    if (i > 'Z') {
                        i = 'A';
                        a = a - 26;
                    }
                    if (i < 'A' + a) {
                        list.get(j).append(i++);
                    }
                }
            }
            curCol++;
        }
        for (int j = 0; j < b; j++) {
            System.out.println(list.get(j));
        }
    }
}
