package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.SumTwoLinkedLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumTwoLinkedListsTest {

    private SumTwoLinkedLists sumTwoLinkedListsUnderTest;

    @BeforeEach
    void setUp() {
        sumTwoLinkedListsUnderTest = new SumTwoLinkedLists();
    }

    @Test
    void testMySelf_SumTwoLinkedLists() {
        // Setup
        final SumTwoLinkedLists.ListNode firstListHeaderNode = new SumTwoLinkedLists.ListNode(0);
        final SumTwoLinkedLists.ListNode secondHeaderListNode = new SumTwoLinkedLists.ListNode(0);
        final SumTwoLinkedLists.ListNode expectedResult = new SumTwoLinkedLists.ListNode(0);

        // Run the test
        final SumTwoLinkedLists.ListNode result = sumTwoLinkedListsUnderTest.mySelf_SumTwoLinkedLists(
                firstListHeaderNode, secondHeaderListNode);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
