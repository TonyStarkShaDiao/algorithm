package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.MergingTwoOrderNodeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergingTwoOrderNodeListTest {

    MergingTwoOrderNodeList mergingTwoOrderNodeList;
    MergingTwoOrderNodeList.ListNode firstOneHeaderList;
    MergingTwoOrderNodeList.ListNode secondOneHeaderList;
    MergingTwoOrderNodeList.ListNode expectHeaderList;

    @BeforeEach
    void setUp() {
        mergingTwoOrderNodeList = new MergingTwoOrderNodeList();
        firstOneHeaderList = new MergingTwoOrderNodeList.ListNode(1);
        firstOneHeaderList.next = new MergingTwoOrderNodeList.ListNode(2);
        firstOneHeaderList.next.next = new MergingTwoOrderNodeList.ListNode(4);
        secondOneHeaderList = new MergingTwoOrderNodeList.ListNode(1);
        secondOneHeaderList.next = new MergingTwoOrderNodeList.ListNode(3);
        secondOneHeaderList.next.next = new MergingTwoOrderNodeList.ListNode(4);
        secondOneHeaderList.next.next.next = new MergingTwoOrderNodeList.ListNode(6);
        expectHeaderList = new MergingTwoOrderNodeList.ListNode(1);
        expectHeaderList.next = new MergingTwoOrderNodeList.ListNode(2);
        expectHeaderList.next.next = new MergingTwoOrderNodeList.ListNode(3);
        expectHeaderList.next.next.next = new MergingTwoOrderNodeList.ListNode(4);
        expectHeaderList.next.next.next.next = new MergingTwoOrderNodeList.ListNode(6);
        expectHeaderList.next.next.next.next.next = new MergingTwoOrderNodeList.ListNode(7);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_TemporaryNodeMergeTwoLists() {
        MergingTwoOrderNodeList.ListNode listNode = mergingTwoOrderNodeList.mySelf_TemporaryNodeMergeTwoLists(firstOneHeaderList, secondOneHeaderList);
        assertEquals(expectHeaderList, listNode);

    }

    @Test
    void mySelf_RecursiveNodeMergeTwoLists() {
        MergingTwoOrderNodeList.ListNode listNode = mergingTwoOrderNodeList.mySelf_RecursiveNodeMergeTwoLists(firstOneHeaderList, secondOneHeaderList);
        assertEquals(expectHeaderList, listNode);
    }

    @Test
    void mySelf_SecondTemporaryListNodeMergeTwoLists() {
        MergingTwoOrderNodeList.ListNode listNode = mergingTwoOrderNodeList.mySelf_SecondTemporaryListNodeMergeTwoLists(firstOneHeaderList, secondOneHeaderList);
        assertEquals(expectHeaderList, listNode);
    }
}