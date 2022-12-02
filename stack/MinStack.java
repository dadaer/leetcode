package stack;

import java.util.Stack;

/**
 * stack用来存储和min的差值，min存储最小值，每次出栈的时候通过差值和当前min计算要出栈的值和之前的min
 * 如果差值diff大于等于0，说明要出栈的值大于等于当前min，那么要出栈的值在入栈的时候没有更新min，
 * 返回min+diff；
 * 如果插值diff小于0，说明当前要出栈的值就是min(因为入栈的时候我们选择的就是min和入栈元素的最小值)，
 * 同时，通过min-diff计算出之前min
 * 要注意的是diff可能会超出int范围，类似于 Integer.MAX_VALUE - 1 这种，所以diff要用Long存
 *
 */
class MinStack {

    // 数组栈, [当前值, 当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(new int[]{x, x});
        }else {
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