package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.ExchangeNodesInLinkedListInPairs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeNodesInLinkedListInPairsTest {

    ExchangeNodesInLinkedListInPairs exchangeNodesInLinkedListInPairs;
    ExchangeNodesInLinkedListInPairs.ListNode head;
    ExchangeNodesInLinkedListInPairs.ListNode expectHead;

    @BeforeEach
    void setUp() {
        exchangeNodesInLinkedListInPairs = new ExchangeNodesInLinkedListInPairs();
        head = new ExchangeNodesInLinkedListInPairs.ListNode(1);
        head.next = new ExchangeNodesInLinkedListInPairs.ListNode(2);
        head.next.next = new ExchangeNodesInLinkedListInPairs.ListNode(3);
        head.next.next.next = new ExchangeNodesInLinkedListInPairs.ListNode(4);
        expectHead = new ExchangeNodesInLinkedListInPairs.ListNode(2);
        expectHead.next = new ExchangeNodesInLinkedListInPairs.ListNode(1);
        expectHead.next.next = new ExchangeNodesInLinkedListInPairs.ListNode(4);
        expectHead.next.next.next = new ExchangeNodesInLinkedListInPairs.ListNode(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_ExchangeNodesInLinkedListInPairs() {
        ExchangeNodesInLinkedListInPairs.ListNode needChecklistNode = exchangeNodesInLinkedListInPairs.MySelf_ExchangeNodesInLinkedListInPairs(head);
        assertEquals(expectHead, needChecklistNode);
    }

    @Test
    void mySelf_SecondExchangeNodesInLinkedListInPairs() {
        ExchangeNodesInLinkedListInPairs.ListNode needChecklistNode = exchangeNodesInLinkedListInPairs.MySelf_SecondExchangeNodesInLinkedListInPairs(head);
        assertEquals(expectHead, needChecklistNode);
    }
}