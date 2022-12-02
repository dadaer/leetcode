package stack;

import java.util.Stack;


public class ValidateStackSequences {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        int[] indexs = new int[popped.length];
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            for (int j = 0; j < pushed.length; j++) {
                if (pushed[j] == popped[i]) {
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
