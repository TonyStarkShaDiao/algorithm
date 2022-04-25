package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.ReverseNodeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNodeListTest {

    private ReverseNodeList reverseNodeList;
    private ReverseNodeList.ListNode listNode;
    private ReverseNodeList.ListNode expectListNode;

    @BeforeEach
    void setUp() {
        reverseNodeList = new ReverseNodeList();
        listNode = new ReverseNodeList.ListNode(1);
        listNode.next = new ReverseNodeList.ListNode(2);
        listNode.next.next = new ReverseNodeList.ListNode(3);
        listNode.next.next.next = new ReverseNodeList.ListNode(4);
        expectListNode = new ReverseNodeList.ListNode(4);
        expectListNode.next = new ReverseNodeList.ListNode(3);
        expectListNode.next.next = new ReverseNodeList.ListNode(2);
        expectListNode.next.next.next = new ReverseNodeList.ListNode(1);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_ThirdIterationReversalLinkedList() {
        ReverseNodeList.ListNode needCheckListNode = reverseNodeList.mySelf_ThirdIterationReversalLinkedList(listNode);
        assertEquals(expectListNode, needCheckListNode);
    }
}