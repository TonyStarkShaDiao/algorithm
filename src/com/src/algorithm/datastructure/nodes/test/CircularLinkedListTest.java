package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.CircularLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {
    CircularLinkedList.ListNode listNode;
    CircularLinkedList circularLinkedList;
    @BeforeEach
    void setUp() {
        circularLinkedList =new CircularLinkedList();
        listNode=new CircularLinkedList.ListNode(0);
        CircularLinkedList.ListNode listNode1= new CircularLinkedList.ListNode(1);
        CircularLinkedList.ListNode listNode2 = new CircularLinkedList.ListNode(2);
        CircularLinkedList.ListNode listNode3 = new CircularLinkedList.ListNode(3);
        CircularLinkedList.ListNode listNode4 = new CircularLinkedList.ListNode(4);
        CircularLinkedList.ListNode listNode5 = new CircularLinkedList.ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
//        listNode5.next=listNode2;
    }

    @AfterEach
    void tearDown() {
    }
    @DisplayName("hash 是环形链表测试结果")
    @Test
    void myself_HashCountSuccess() {
        Boolean judgeRingResult = circularLinkedList.myself_HashCount(listNode);
        assertTrue(judgeRingResult,"hash算法答案应该是个环形链表");
    }
    @DisplayName("快慢指针 是环形链表测试结果")
    @Test
    void myself_FastSlowPointerSuccess() {
        Boolean judgeRingResult = circularLinkedList.myself_HashCount(listNode);
        assertTrue(judgeRingResult,"hash算法答案应该是个环形链表");
    }

    @DisplayName("hash 不是环形链表测试结果")
    @Test
    void myself_HashCountFail() {

        Boolean judgeRingResult = circularLinkedList.myself_HashCount(listNode);
        assertFalse(judgeRingResult,"hash算法答案不是个环形链表");
    }
    @DisplayName("快慢指针 不是环形链表测试结果")
    @Test
    void myself_FastSlowPointerFail() {
        Boolean judgeRingResult = circularLinkedList.myself_HashCount(listNode);
        assertFalse(judgeRingResult,"hash算法答案应该不是个环形链表");
    }
}