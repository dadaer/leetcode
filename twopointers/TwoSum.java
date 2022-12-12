package twopointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0},-1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        return null;
    }
}
