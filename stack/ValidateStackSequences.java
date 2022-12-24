package stack;

import java.util.Stack;

/**
 * @source: 剑指offer31
 * @difficulty: medium
 * @topic: 栈的压入、弹出序列
 * @link: https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等
 * @input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * @output: true
 * @requirements:
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        int[] indexs = new int[popped.length];
        int index = 0;
        for (int k : popped) {
            for (int j = 0; j < pushed.length; j++) {
                if (pushed[j] == k) {
                    indexs[index++] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < indexs.length; i++) {
            int cur = indexs[i];
            for (int j = i + 1; j <  indexs.length; j++) {
                if (indexs[j] > indexs[i]) {
                    continue;
                } else if (indexs[j] < cur) {
                    cur = indexs[j];
                }else if (indexs[j] > cur && indexs[j] < indexs[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
