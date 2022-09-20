package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.ReverseLinkedListII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseLinkedListIITest {

    private ReverseLinkedListII reverseLinkedListIIUnderTest;
    ReverseLinkedListII.ListNode listNode;

    @BeforeEach
    void setUp() {
        reverseLinkedListIIUnderTest = new ReverseLinkedListII();
        listNode = new ReverseLinkedListII.ListNode(1);
        listNode.next = new ReverseLinkedListII.ListNode(2);
        listNode.next.next = new ReverseLinkedListII.ListNode(3);
        listNode.next.next.next = new ReverseLinkedListII.ListNode(4);
        listNode.next.next.next.next = new ReverseLinkedListII.ListNode(5);
        listNode.next.next.next.next.next = new ReverseLinkedListII.ListNode(6);
    }

    @Test
    void testMySelf_reverse() {
        final ReverseLinkedListII.ListNode result = reverseLinkedListIIUnderTest.mySelf_reverse(listNode, 2, 4);
    }
}
