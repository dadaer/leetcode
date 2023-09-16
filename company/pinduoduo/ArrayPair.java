package company.pinduoduo;

import java.util.*;

public class ArrayPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums); // 对数字数组进行排序

        int count = 0; // 计数器
        int i = 0; // 左指针
        int j = 1; // 右指针
        while (j < N) {
            if (nums[j] - nums[i] >= M) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        System.out.println(count); // 输出能够匹配的最多数字对的个数
    }
}
