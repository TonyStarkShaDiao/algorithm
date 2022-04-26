package com.src.algorithm.datastructure.stack.prod;

import java.util.Stack;

/**
 * 最小堆栈
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/26
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack();
    }

    public void push(int element) {
        if (element <= min) {
            stack.push(min);
            min = element;
        }
        stack.push(element);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        Integer currentStackElement = stack.peek();
        return currentStackElement;
    }

    public int getMin() {
        return min;
    }
}
