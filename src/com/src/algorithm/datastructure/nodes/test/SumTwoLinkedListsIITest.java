package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.SumTwoLinkedListsII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumTwoLinkedListsIITest {

    private SumTwoLinkedListsII sumTwoLinkedListsIIUnderTest;
    private SumTwoLinkedListsII.ListNode firstOneListNode;
    private SumTwoLinkedListsII.ListNode secondOneListNode;

    @BeforeEach
    void setUp() {
        sumTwoLinkedListsIIUnderTest = new SumTwoLinkedListsII();
        firstOneListNode = new SumTwoLinkedListsII.ListNode(7);
        firstOneListNode.next = new SumTwoLinkedListsII.ListNode(2);
        firstOneListNode.next.next = new SumTwoLinkedListsII.ListNode(4);
        firstOneListNode.next.next.next = new SumTwoLinkedListsII.ListNode(3);
        secondOneListNode = new SumTwoLinkedListsII.ListNode(5);
        secondOneListNode.next = new SumTwoLinkedListsII.ListNode(6);
        secondOneListNode.next.next = new SumTwoLinkedListsII.ListNode(4);
    }

    @Test
    void testReversalSumTwoLinkedLists() {

        final SumTwoLinkedListsII.ListNode result = sumTwoLinkedListsIIUnderTest.reversalSumTwoLinkedLists(
                firstOneListNode, secondOneListNode);

        // Verify the results
    }
}
