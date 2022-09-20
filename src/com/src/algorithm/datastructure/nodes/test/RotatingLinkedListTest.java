package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.RotatingLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotatingLinkedListTest {

    private RotatingLinkedList rotatingLinkedListUnderTest;
    private RotatingLinkedList.ListNode beforeRotationListNodeHeader;
    private int numberOfRotations;
    private RotatingLinkedList.ListNode expectAfterRotationListNodeHeader;

    @BeforeEach
    void setUp() {
        rotatingLinkedListUnderTest = new RotatingLinkedList();
        beforeRotationListNodeHeader = new RotatingLinkedList.ListNode(1);
        beforeRotationListNodeHeader.next = new RotatingLinkedList.ListNode(2);
        beforeRotationListNodeHeader.next.next = new RotatingLinkedList.ListNode(3);
        beforeRotationListNodeHeader.next.next.next = new RotatingLinkedList.ListNode(4);
        beforeRotationListNodeHeader.next.next.next.next = new RotatingLinkedList.ListNode(5);
        numberOfRotations = 2;
        expectAfterRotationListNodeHeader = beforeRotationListNodeHeader.next.next.next;
    }

    @Test
    void testMySelf_doublePointRotatingLinkedList() {
        final RotatingLinkedList.ListNode result = rotatingLinkedListUnderTest.mySelf_doublePointRotatingLinkedList(
                beforeRotationListNodeHeader, numberOfRotations);
        assertThat(result).isEqualTo(expectAfterRotationListNodeHeader);
    }
}
