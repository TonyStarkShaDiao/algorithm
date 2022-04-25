package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.DeleteDuplicateElementsInSortingLinkedListII;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteDuplicateElementsInSortingLinkedListIITest {

    private DeleteDuplicateElementsInSortingLinkedListII deleteDuplicateElementsInSortingLinkedListII;
    private DeleteDuplicateElementsInSortingLinkedListII.ListNode needDuplicateRemovalHeaderListNode;
    private DeleteDuplicateElementsInSortingLinkedListII.ListNode expectListNode;

    @BeforeEach
    void setUp() {
        deleteDuplicateElementsInSortingLinkedListII = new DeleteDuplicateElementsInSortingLinkedListII();
        needDuplicateRemovalHeaderListNode = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(1);
        needDuplicateRemovalHeaderListNode.next = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(1);
        needDuplicateRemovalHeaderListNode.next.next = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(2);
        needDuplicateRemovalHeaderListNode.next.next.next = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(3);
        expectListNode = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(2);
        expectListNode.next = new DeleteDuplicateElementsInSortingLinkedListII.ListNode(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_DeleteDuplicateElementsInSortingLinkedListII() {
        DeleteDuplicateElementsInSortingLinkedListII.ListNode needChecklistNode = deleteDuplicateElementsInSortingLinkedListII.mySelf_DeleteDuplicateElementsInSortingLinkedListII(needDuplicateRemovalHeaderListNode);
        assertEquals(expectListNode, needChecklistNode);
    }
}