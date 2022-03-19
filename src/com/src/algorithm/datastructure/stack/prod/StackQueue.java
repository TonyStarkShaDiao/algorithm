package com.src.algorithm.datastructure.stack.prod;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 堆栈队列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/21
 */
public class StackQueue<T> {
    Deque<T> inElementStack;
    Deque<T> outElementStack;

    public StackQueue() {
        inElementStack = new LinkedList<>();
        outElementStack = new LinkedList<>();
    }

    public void push(T element) {

        inElementStack.push(element);
    }

    public T pop() {
        if (outElementStack.isEmpty()) {
            refreshQueue();
        }
        if (outElementStack.isEmpty()){
            return null;
        }
        return outElementStack.pop();
    }

    private void refreshQueue() {
        while (!inElementStack.isEmpty()) {
            outElementStack.push(inElementStack.pop());
        }
    }

    public T peek() {
        if (outElementStack.isEmpty()){
            refreshQueue();
        }
        return outElementStack.peek();
    }

    public boolean empty() {
        return inElementStack.isEmpty()&&outElementStack.isEmpty();
    }
}
