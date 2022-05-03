package com.src.algorithm.datastructure.stack.prod;

import java.util.Stack;

/**
 * 验证堆栈序列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/01
 */
public class VerificationStackSequence {

    public Boolean mySelf_VerificationStackSequence(int[] pushArray, int[] popArray) {
        Stack<Integer> stack = new Stack<>();
        int popArrayIndex = 0;
        for (int i = 0; i < pushArray.length; i++) {
            stack.push(pushArray[i]);
            while (!stack.isEmpty() && stack.peek() == popArray[popArrayIndex]) {
                stack.pop();
                popArrayIndex++;
            }
        }
        return stack.isEmpty();
    }
}
