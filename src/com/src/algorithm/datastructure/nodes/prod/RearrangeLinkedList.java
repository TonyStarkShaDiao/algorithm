package com.src.algorithm.datastructure.nodes.prod;

import sun.nio.ch.sctp.SendFailed;

/**
 * 重新排列链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/25
 */
public class RearrangeLinkedList {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof SumTwoLinkedLists.ListNode) {
                ListNode node = (ListNode) obj;
                ListNode tempListNode = new ListNode(value);
                tempListNode.next = next;
                while (node != null) {
                    System.out.println(tempListNode.value);
                    if (node.value != tempListNode.value) {
                        return false;
                    }
                    node = node.next;
                    tempListNode = tempListNode.next;
                }
            }
            return true;
        }
    }

    public void mySelf_RearrangeLinkedList(ListNode headerListNode) {
        ListNode dummyListNode = new ListNode(0, headerListNode);
        ListNode intermediateNode = this.getIntermediateNode(dummyListNode.next);
        ListNode secondHalf = intermediateNode.next;
        ListNode firstHalf = dummyListNode.next;
        intermediateNode.next = null;
        secondHalf = this.newReverseLinkedList(secondHalf);
        this.mergeTwoLinkedLists(firstHalf, secondHalf);
    }

    private void mergeTwoLinkedLists(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            ListNode firstHalfNext = firstHalf.next;
            ListNode secondHalfNext = secondHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = firstHalfNext;
            secondHalf.next = firstHalfNext;
            secondHalf = secondHalfNext;
        }
    }

    private ListNode newReverseLinkedList(ListNode secondHalf) {
        ListNode previous = null;
        while (secondHalf != null) {
            ListNode secondHalfNext = secondHalf.next;
            secondHalf.next = previous;
            previous = secondHalf;
            secondHalf = secondHalfNext;
        }
        return previous;
    }

    private ListNode getIntermediateNode(ListNode headerListNode) {
        ListNode slowListNode = headerListNode;
        ListNode fastListNode = headerListNode;
        while (fastListNode.next != null && fastListNode.next.next != null) {
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }

        return slowListNode;
    }

    public void myself_ThreeStepsRearrangeLinkedList(ListNode headerListNode) {
        ListNode dummyListNode = new ListNode(0, headerListNode);
        ListNode slowListNode = dummyListNode.next;
        ListNode fastListNode = dummyListNode.next;
        while (fastListNode.next != null && fastListNode.next.next != null) {
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }
        ListNode firstHalf = dummyListNode.next;
        ListNode secondHalf = slowListNode.next;
        slowListNode.next = null;
        secondHalf = this.reverseLinkedList(secondHalf);
        this.mergeTwoLinkedLists(dummyListNode, firstHalf, secondHalf);

    }

    private void mergeTwoLinkedLists(ListNode dummyListNode, ListNode firstHalf, ListNode reversalSecondHalf) {
        while (reversalSecondHalf != null && firstHalf != null) {
            ListNode tempFirstHalfNext = firstHalf.next;
            ListNode tempReversalSecondHalfNext = reversalSecondHalf.next;
            firstHalf.next = reversalSecondHalf;
            firstHalf = tempFirstHalfNext;
            reversalSecondHalf.next = tempFirstHalfNext;
            reversalSecondHalf = tempReversalSecondHalfNext;
        }

    }

    private ListNode reverseLinkedList(ListNode secondHalf) {
        ListNode previousListNode = null;
        while (secondHalf != null) {
            ListNode currentList = secondHalf.next;
            secondHalf.next = previousListNode;
            previousListNode = secondHalf;
            secondHalf = currentList;
        }
        return previousListNode;
    }
}
