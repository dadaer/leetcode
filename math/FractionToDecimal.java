package math;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 6));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator; // 处理超出 int 范围
        // 处理 负数
        if (a > 0 && b < 0 || a < 0 && b > 0) sb.append('-');
        //
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0) return sb.toString();
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        // 求余数 除法模拟
        while ((a = (a % b) * 10) != 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
//        a = (a % b) * 10;
//        while (a != 0 && !map.containsKey(a)) {
//            map.put(a, sb.length());
//            sb.append(a / b);
//            a = (a % b) * 10;
//        }
        // 无循环
        if (a == 0) return sb.toString();
        //
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }
}
