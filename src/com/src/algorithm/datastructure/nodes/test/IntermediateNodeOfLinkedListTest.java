package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.IntermediateNodeOfLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 链表测试中间节点
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/25
 */
class IntermediateNodeOfLinkedListTest {

    IntermediateNodeOfLinkedList intermediateNodeOfLinkedList;
    IntermediateNodeOfLinkedList.ListNode oddHeaderListNode;
    IntermediateNodeOfLinkedList.ListNode evenHeaderListNode;
    IntermediateNodeOfLinkedList.ListNode oddExpectListNode;

    IntermediateNodeOfLinkedList.ListNode evenExpectListNode;

    @BeforeEach
    void setUp() {
        intermediateNodeOfLinkedList = new IntermediateNodeOfLinkedList();
        oddHeaderListNode = new IntermediateNodeOfLinkedList.ListNode(1);
        oddHeaderListNode.next = new IntermediateNodeOfLinkedList.ListNode(2);
        oddHeaderListNode.next.next = new IntermediateNodeOfLinkedList.ListNode(3);
        oddHeaderListNode.next.next.next = new IntermediateNodeOfLinkedList.ListNode(4);
        oddHeaderListNode.next.next.next.next = new IntermediateNodeOfLinkedList.ListNode(5);
        oddHeaderListNode.next.next.next.next.next = new IntermediateNodeOfLinkedList.ListNode(6);
        oddHeaderListNode.next.next.next.next.next.next = new IntermediateNodeOfLinkedList.ListNode(7);
        oddExpectListNode = oddHeaderListNode.next.next.next;
        evenHeaderListNode = new IntermediateNodeOfLinkedList.ListNode(1);
        evenHeaderListNode.next = new IntermediateNodeOfLinkedList.ListNode(2);
        evenHeaderListNode.next.next = new IntermediateNodeOfLinkedList.ListNode(3);
        evenHeaderListNode.next.next.next = new IntermediateNodeOfLinkedList.ListNode(4);
        evenHeaderListNode.next.next.next.next = new IntermediateNodeOfLinkedList.ListNode(5);
        evenHeaderListNode.next.next.next.next.next = new IntermediateNodeOfLinkedList.ListNode(6);
        evenExpectListNode = evenHeaderListNode.next.next.next;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("testGetIntermediateNodeOfLinkedList for odd length")
    void mySelf_FastSlowPointFindIntermediateNodeOfLinkedListOddNumber() {
        IntermediateNodeOfLinkedList.ListNode oldCheckListNode = intermediateNodeOfLinkedList.mySelf_FastSlowPointFindIntermediateNodeOfLinkedList(oddHeaderListNode);
        assertEquals(oddExpectListNode, oldCheckListNode);
    }

    @Test
    @DisplayName("testGetIntermediateNodeOfLinkedList for even length")
    void mySelf_FastSlowPointFindIntermediateNodeOfLinkedListEvenNumber() {
        IntermediateNodeOfLinkedList.ListNode evenNeedCheckListNode = intermediateNodeOfLinkedList.mySelf_FastSlowPointFindIntermediateNodeOfLinkedList(evenHeaderListNode);
        assertEquals(evenExpectListNode, evenNeedCheckListNode);
    }

}