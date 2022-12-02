package stack;

import java.util.Stack;

/**
 * @source: leetcode232
 * @difficulty: easy
 * @topic: 两个栈实现队列
 * @link: https://leetcode.cn/problems/implement-queue-using-stacks/
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * @input:
 * @output:
 * @requirements:
 */
public class MyQueue {
    //两个栈，一个出栈，一个入栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
