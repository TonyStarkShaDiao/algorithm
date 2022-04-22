package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.nodes.prod.SumTwoLinkedLists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTwoLinkedListsTest {

    SumTwoLinkedLists.ListNode firstListNode;
    SumTwoLinkedLists.ListNode secondListNode;
    SumTwoLinkedLists sumTwoLinkedLists;
    SumTwoLinkedLists.ListNode expectListNode;

    @BeforeEach
    void setUp() {
        sumTwoLinkedLists = new SumTwoLinkedLists();
        firstListNode = new SumTwoLinkedLists.ListNode(1);
        secondListNode = new SumTwoLinkedLists.ListNode(1);
        secondListNode.next = new SumTwoLinkedLists.ListNode(2);
        secondListNode.next.next = new SumTwoLinkedLists.ListNode(3);
        secondListNode.next.next.next = new SumTwoLinkedLists.ListNode(4);
        expectListNode = new SumTwoLinkedLists.ListNode(2);
        expectListNode.next = new SumTwoLinkedLists.ListNode(2);
        expectListNode.next.next = new SumTwoLinkedLists.ListNode(3);
        expectListNode.next.next.next = new SumTwoLinkedLists.ListNode(4);
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test sum two linked list")
    @Test
    void mySelf_SumTwoLinkedLists() {
        SumTwoLinkedLists.ListNode listNode = sumTwoLinkedLists.mySelf_SumTwoLinkedLists(firstListNode, secondListNode);
        assertEquals(expectListNode, listNode);

    }
}