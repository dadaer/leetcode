package company.weilai;

import java.util.*;

public class FindNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int length = in.nextInt();

        int[] nums = new int[length];

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }

        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= length / 2) {
                ans = entry.getKey();
            }
        }

        System.out.println(ans);
    }
}
