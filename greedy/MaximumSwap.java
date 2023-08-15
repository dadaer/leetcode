package greedy;

/**
 * @source: leetcode670
 * @difficulty: medium
 * @topic: 最大交换
 * @link: https://leetcode.cn/problems/maximum-swap/
 * @description: 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @input: 2736
 * @output: 7236
 * @requirements:
 */
public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap0(12));
    }

    // 贪心
    public static int maximumSwap0(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = maxIdx;
        for (int i = n - 2; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
                idx2 = maxIdx;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    // 暴力
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        int index;
        for (int i = 0; i < length; i++) {
            index = i;
            for (int j = i + 1; j < length; j++) {
                if (chars[j] > chars[i]) {
                    if (chars[j] >= chars[index]) {
                        index = j;
                    }
                }
            }
            if (index != i) {
                swap(chars, i, index);
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }


    private static void swap(char[] charArray, int idx1, int idx2) {
        char temp = charArray[idx1];
        charArray[idx1] = charArray[idx2];
        charArray[idx2] = temp;
    }
}
