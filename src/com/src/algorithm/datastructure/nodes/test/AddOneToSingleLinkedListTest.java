package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.AddOneToSingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddOneToSingleLinkedListTest {

    private AddOneToSingleLinkedList addOneToSingleLinkedListUnderTest;
    private AddOneToSingleLinkedList.ListNode head;

    @BeforeEach
    void setUp() {
        addOneToSingleLinkedListUnderTest = new AddOneToSingleLinkedList();
        head = new AddOneToSingleLinkedList.ListNode(1);
        head.next = new AddOneToSingleLinkedList.ListNode(2);
        head.next.next = new AddOneToSingleLinkedList.ListNode(3);
    }

    @Test
    void testMySelf_reverseLinkedListAddOneToSingleLinkedList() {
        final AddOneToSingleLinkedList.ListNode result = addOneToSingleLinkedListUnderTest.mySelf_reverseLinkedListAddOneToSingleLinkedList(
                head);

        // Verify the results
    }
}
