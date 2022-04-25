package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.IntersectingLinkedList;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 交叉链表测试
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/22
 */

class IntersectingLinkedListTest {

    private IntersectingLinkedList intersectingLinkedList;
    private IntersectingLinkedList.ListNode firstNode;
    private IntersectingLinkedList.ListNode secondNode;
    private IntersectingLinkedList.ListNode intersectNode;
    private IntersectingLinkedList.ListNode expectNode;

    @BeforeEach
    void setUp() {
        intersectingLinkedList = new IntersectingLinkedList();
        intersectNode = new IntersectingLinkedList.ListNode(3);
        intersectNode.next = new IntersectingLinkedList.ListNode(4);
        firstNode = new IntersectingLinkedList.ListNode(1);
        firstNode.next = new IntersectingLinkedList.ListNode(2);
        firstNode.next.next = new IntersectingLinkedList.ListNode(3);
        firstNode.next.next.next = intersectNode;
        secondNode = new IntersectingLinkedList.ListNode(2);
        secondNode.next = new IntersectingLinkedList.ListNode(9);
        secondNode.next.next = intersectNode;
        secondNode.next.next.next = new IntersectingLinkedList.ListNode(4);
        expectNode = intersectNode;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("测试交叉链表")
    void mySelf_LoveIntersectingLinkedList() {
        IntersectingLinkedList.ListNode needChecklistNode = intersectingLinkedList.mySelf_LoveIntersectingLinkedList(firstNode, secondNode);
        assertEquals(expectNode, needChecklistNode);
    }

    @Test
    @DisplayName("不交叉链表")
    void mySelf_LoveNotIntersectingLinkedList() {
        firstNode = new IntersectingLinkedList.ListNode(1);
        secondNode = new IntersectingLinkedList.ListNode(2);
        expectNode = null;
        IntersectingLinkedList.ListNode needChecklistNode = intersectingLinkedList.mySelf_LoveIntersectingLinkedList(firstNode, secondNode);
        System.out.println(needChecklistNode == null);
        assertEquals(expectNode, needChecklistNode);
    }
}