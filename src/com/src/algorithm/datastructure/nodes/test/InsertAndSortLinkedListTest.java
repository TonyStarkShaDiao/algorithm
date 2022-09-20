package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.InsertAndSortLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertAndSortLinkedListTest {

    private InsertAndSortLinkedList insertAndSortLinkedListUnderTest;
    private InsertAndSortLinkedList.ListNode linkedListToBeSorted;

    @BeforeEach
    void setUp() {
        insertAndSortLinkedListUnderTest = new InsertAndSortLinkedList();
        linkedListToBeSorted = new InsertAndSortLinkedList.ListNode(2);
        linkedListToBeSorted.next = new InsertAndSortLinkedList.ListNode(1);
        linkedListToBeSorted.next.next = new InsertAndSortLinkedList.ListNode(7);
        linkedListToBeSorted.next.next.next = new InsertAndSortLinkedList.ListNode(6);
    }

    @Test
    void testMySelf_InsertAndSortLinkedList() {
        // Setup
        // Run the test
        final InsertAndSortLinkedList.ListNode result = insertAndSortLinkedListUnderTest.mySelf_InsertAndSortLinkedList(
                linkedListToBeSorted);

        // Verify the results
    }
}
