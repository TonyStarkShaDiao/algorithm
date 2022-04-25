package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.groupOfKInvertedLinkedLists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class groupOfKInvertedLinkedListsTest {

    groupOfKInvertedLinkedLists groupOfKInvertedLinkedLists;
    groupOfKInvertedLinkedLists.ListNode listNode;
    int numberOfGroups;

    @BeforeEach
    void setUp() {
        groupOfKInvertedLinkedLists = new groupOfKInvertedLinkedLists();
        listNode = new groupOfKInvertedLinkedLists.ListNode(1);
        listNode.next = new groupOfKInvertedLinkedLists.ListNode(2);
        listNode.next.next = new groupOfKInvertedLinkedLists.ListNode(3);
        listNode.next.next.next = new groupOfKInvertedLinkedLists.ListNode(4);
        listNode.next.next.next.next = new groupOfKInvertedLinkedLists.ListNode(5);
        listNode.next.next.next.next.next = new groupOfKInvertedLinkedLists.ListNode(6);
        listNode.next.next.next.next.next.next = new groupOfKInvertedLinkedLists.ListNode(7);
        numberOfGroups = 3;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_GroupOfKInvertedLinkedLists() {
        groupOfKInvertedLinkedLists.ListNode listNode1 = groupOfKInvertedLinkedLists.MySelf_GroupOfKInvertedLinkedLists(listNode, numberOfGroups);
        System.out.println(listNode1);
    }
}