package design;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @source: leetcode155
 * @difficulty: medium
 * @topic: 最小栈
 * @link: https://leetcode.cn/problems/min-stack/
 * @description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * @output: [null, null, null, null,-3,null,0,-2]
 * @requirements:
 */
class MinStack {

    // 数组栈, [当前值, 当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

class MinStack1 {
    LinkedList<Long> stack;
    // 当前【已压入】栈中元素的最小值
    private long min;

    public MinStack1() {
        stack = new LinkedList();
    }

    public void push(int val) {
        // 压入第一个元素
        if (stack.isEmpty()) {
            min = val;
            stack.addFirst(0L);
            return;
        }
        // 栈不为空时，每次压入计算与 min 的差值后压入结果
        stack.push((long) val - min);
        // 更新 min
        min = Math.min(val, min);
        // 上面两个语句是不能颠倒的！一定是先压入，再更新，因为 min 一定是当前栈中的最小值
    }

    public void pop() {
        long pop = stack.removeFirst();
        // 当弹出元素小于 0 时，说明弹出元素是当前栈中的最小值，要更新最小值
        if (pop < 0) {
            // 因为对于当前弹出的元素而言，计算压入栈中的值时，计算的是该元素与【未压入】该元素时
            // 栈中元素的最小值的差值，故弹出该元素后栈中的最小值就是未压入该元素时的最小值
            // 即当前元素的值（min）减去两者的差值
            long lastMin = min;
            min = lastMin - pop;
        }
        // 若大于等于0，不会对min有影响
    }

    public int top() {
        long peek = stack.peek();
        // 若当前栈顶小于等于 0，说明最小值就是栈顶元素
        if (peek <= 0) {
            return (int) min;
        }
        // 否则就是 min + peek
        return (int) (min + peek);
    }

    public int getMin() {
        return (int) min;
    }
}