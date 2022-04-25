package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.AnnularLinkedListII;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.undo.AbstractUndoableEdit;

import static org.junit.jupiter.api.Assertions.*;

class AnnularLinkedListIITest {

    private AnnularLinkedListII annularLinkedListII;
    private AnnularLinkedListII.ListNode needCheckHeaderListNode;
    private AnnularLinkedListII.ListNode expectHeaderListNode;

    @BeforeEach
    void setUp() {
        annularLinkedListII = new AnnularLinkedListII();
        needCheckHeaderListNode = new AnnularLinkedListII.ListNode(1);
        needCheckHeaderListNode.next = new AnnularLinkedListII.ListNode(2);
        needCheckHeaderListNode.next.next = new AnnularLinkedListII.ListNode(3);
        needCheckHeaderListNode.next.next.next = new AnnularLinkedListII.ListNode(4);
        needCheckHeaderListNode.next.next.next.next = needCheckHeaderListNode.next.next;
        expectHeaderListNode = needCheckHeaderListNode.next.next;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("环形链表II测试")
    void mySelf_freudianAlgorithmAnnularLinkedListII() {
        AnnularLinkedListII.ListNode stayCheckHeaderListNode = annularLinkedListII.mySelf_freudianAlgorithmAnnularLinkedListII(needCheckHeaderListNode);
        assertEquals(expectHeaderListNode, stayCheckHeaderListNode);
    }
}