package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.DeleteTheReciprocalNodeOfTheLinkedListForN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteTheReciprocalNodeOfTheLinkedListForNTest {
    DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode head;
    private DeleteTheReciprocalNodeOfTheLinkedListForN deleteTheReciprocalNodeOfTheLinkedListForNUnderTest;

    @BeforeEach
    void setUp() {
        deleteTheReciprocalNodeOfTheLinkedListForNUnderTest = new DeleteTheReciprocalNodeOfTheLinkedListForN();
        head = new DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode(1);
        head.next = new DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode(2);
//        head.next.next = new DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode(3);
//        head.next.next.next = new DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode(4);
//        head.next.next.next.next = new DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode(6);
    }

    @Test
    void testRemoveNthFromEnd() {
        final DeleteTheReciprocalNodeOfTheLinkedListForN.ListNode result = deleteTheReciprocalNodeOfTheLinkedListForNUnderTest.removeNthFromEnd(
                head, 2);

        // Verify the results
    }
}
