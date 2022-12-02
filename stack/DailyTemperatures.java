package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @source: leetcode739
 * @difficulty: medium
 * @topic: 每日温度
 * @link: https://leetcode.cn/problems/daily-temperatures/
 * @description: 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @input: temperatures = [73,74,75,71,69,72,76,73]
 * @output: [1,1,4,2,1,1,0,0]
 * @requirements:
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int diff = stack.pop();
                res[diff] = i - diff;
            }
            stack.push(i);
        }
        return res;
    }
}
