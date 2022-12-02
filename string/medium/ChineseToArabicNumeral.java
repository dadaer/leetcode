package string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ChineseToArabicNumeral {
    public static void main(String[] args) {
        System.out.println(chineseToArabicNumeral("六"));
        System.out.println(chineseToArabicNumeral("九八七六"));
        System.out.println(chineseToArabicNumeral("一百零一"));
        System.out.println(chineseToArabicNumeral("一万零一"));
        System.out.println(chineseToArabicNumeral("一百万"));
        System.out.println(chineseToArabicNumeral("三千四百零三亿九千八百万零六十六"));
        System.out.println(chineseToArabicNumeral("四百亿九千八百万零六十六"));
    }

    // 中文转阿拉伯文
    public static long chineseToArabicNumeral(String str) {
        Map<Character, Integer> CHINESE_ONES_NUM = new HashMap<>();
        Map<Character, Integer> CHINESE_UNITS_NUM = new HashMap<>();

        CHINESE_ONES_NUM.put('零', 0);
        CHINESE_ONES_NUM.put('一', 1);
        CHINESE_ONES_NUM.put('二', 2);
        CHINESE_ONES_NUM.put('三', 3);
        CHINESE_ONES_NUM.put('四', 4);
        CHINESE_ONES_NUM.put('五', 5);
        CHINESE_ONES_NUM.put('六', 6);
        CHINESE_ONES_NUM.put('七', 7);
        CHINESE_ONES_NUM.put('八', 8);
        CHINESE_ONES_NUM.put('九', 9);

        CHINESE_UNITS_NUM.put('十', 10);
        CHINESE_UNITS_NUM.put('廿', 20);
        CHINESE_UNITS_NUM.put('丗', 20);
        CHINESE_UNITS_NUM.put('百', 100);
        CHINESE_UNITS_NUM.put('千', 1000);
        CHINESE_UNITS_NUM.put('万', 10000);
        CHINESE_UNITS_NUM.put('亿', 100000000);

        Stack<Integer> stack = new Stack<>();
        int length = str.length();
        int index = 0;
        long result = 0;
        int cur_unit = 0;

        for (int i = 0; i < length; i++) {
            if (CHINESE_UNITS_NUM.containsKey(str.charAt(i))) {
                cur_unit = CHINESE_UNITS_NUM.get(str.charAt(i));
                break;
            }
        }

        while (index < length) {
            char c = str.charAt(index);
            if (c == '零') {
                index++;
                continue;
            }
            if (CHINESE_ONES_NUM.containsKey(c)) {
                stack.push(CHINESE_ONES_NUM.get(c));
            } else if (CHINESE_UNITS_NUM.containsKey(c)) {
                if (CHINESE_UNITS_NUM.get(c) <= cur_unit) {
                    result += (long) stack.pop() * CHINESE_UNITS_NUM.get(c);
                } else if (CHINESE_UNITS_NUM.get(c) > cur_unit) {
                    if (!stack.isEmpty()) {
                        result += (long) stack.pop();
                    }
                    result = result * CHINESE_UNITS_NUM.get(c);
                }
                cur_unit = CHINESE_UNITS_NUM.get(c);
            }
            index++;
        }

        if (stack.size() > 1) {
            int factor = 1;
            while (!stack.isEmpty()) {
                result += stack.pop() * factor;
                factor *= 10;
            }
            return result;
        } else {
            return stack.isEmpty() ? result : result + stack.pop();
        }
    }
}
