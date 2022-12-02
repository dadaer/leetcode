package string;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "12..33.4";
        System.out.println(Arrays.toString(s.split("\\.")));
    }
}
