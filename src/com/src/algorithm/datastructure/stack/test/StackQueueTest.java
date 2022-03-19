package com.src.algorithm.datastructure.stack.test;

import com.src.algorithm.datastructure.stack.prod.StackQueue;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackQueueTest {
        StackQueue<Integer> stackQueue;
    @BeforeEach
    void setUp() {
        stackQueue=new StackQueue<>();
        stackQueue.push(1);
        stackQueue.push(2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void push() {
        stackQueue.push(1);
        stackQueue.push(2);
    }

    @Test
    @Order(3)
    void pop() {
        Integer firstOnePopElement = stackQueue.pop();
        Integer secondPopElement = stackQueue.pop();
        assertEquals(firstOnePopElement, 1, "弹出错误 应该返回1");
        assertEquals(secondPopElement, 2, "弹出错误 应该返回1");
    }

    @Test
    @Order(2)
    void peek() {
        Integer firstOnePopElement = stackQueue.peek();
        assertEquals(firstOnePopElement, 1, "弹出错误 应该返回1");
    }

    @Test
    @Order(4)
    void empty() {
        while (stackQueue.pop() != null) {

        }
        stackQueue.empty();
        System.out.println(4);
    }
}