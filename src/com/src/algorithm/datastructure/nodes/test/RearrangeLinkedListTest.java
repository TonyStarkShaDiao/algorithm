package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.RearrangeLinkedList;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeLinkedListTest {

    RearrangeLinkedList rearrangeLinkedList;
    RearrangeLinkedList.ListNode headerListNode;

    RearrangeLinkedList.ListNode expectHeaderListNode;

    @BeforeEach
    void setUp() {
        rearrangeLinkedList = new RearrangeLinkedList();
        headerListNode = new RearrangeLinkedList.ListNode(1);
        headerListNode.next = new RearrangeLinkedList.ListNode(2);
        headerListNode.next.next = new RearrangeLinkedList.ListNode(3);
        headerListNode.next.next.next = new RearrangeLinkedList.ListNode(4);
        headerListNode.next.next.next.next = new RearrangeLinkedList.ListNode(5);
        expectHeaderListNode = new RearrangeLinkedList.ListNode(1);
        expectHeaderListNode.next = new RearrangeLinkedList.ListNode(5);
        expectHeaderListNode.next.next = new RearrangeLinkedList.ListNode(2);
        expectHeaderListNode.next.next.next = new RearrangeLinkedList.ListNode(4);
        expectHeaderListNode.next.next.next.next = new RearrangeLinkedList.ListNode(3);
    }

    //  todo 这个单测要补充
    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_ThreeStepsRearrangeLinkedList() {
        rearrangeLinkedList.myself_ThreeStepsRearrangeLinkedList(headerListNode);
        assertEquals(expectHeaderListNode, headerListNode);
    }

    @Test
    void mySelf_RearrangeLinkedList() {
        rearrangeLinkedList.mySelf_RearrangeLinkedList(headerListNode);
        assertEquals(expectHeaderListNode, headerListNode);
    }
}