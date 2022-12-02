package greedy;

import java.util.Arrays;

/**
 * @source: 剑指offer45
 * @difficulty: medium
 * @topic: 把数组排成最小的数
 * @link: https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @description: 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @input: [3,30,34,5,9]
 * @output: "3033459"
 * @requirements:
 */
public class MinNumber_ {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 30, 12, 5, 9}));
    }

    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //  x + y > y + x 则 x > y
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
