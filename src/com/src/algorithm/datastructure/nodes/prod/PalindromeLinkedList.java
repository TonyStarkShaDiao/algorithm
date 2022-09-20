package com.src.algorithm.datastructure.nodes.prod;

public class PalindromeLinkedList {
    public static class ListNode {
        public int value;
        public ListNode next;

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }

        public ListNode(int index) {
            this.value = index;
            next = null;
        }
    }

    public boolean mySelf_doublePointerPalindromeLinkedList(ListNode header) {
        if (header == null || header.next == null) {
            return true;
        }
        ListNode firstHalf = header;
        ListNode middlePointListNode = this.getMiddlePointer(header);
        ListNode reverseListNode = this.reverseList(middlePointListNode.next);
        boolean checkResult = true;
        while (checkResult && reverseListNode != null) {
            if (header.value != reverseListNode.value) {
                checkResult = false;
            }
            header = header.next;
            reverseListNode = reverseListNode.next;
        }
        middlePointListNode.next = this.reverseList(reverseListNode);
        return checkResult;
    }

    private ListNode reverseList(ListNode middlePointListNode) {
        ListNode previousListNode = null;
        ListNode currentListNode = middlePointListNode;
        while (currentListNode != null) {
            ListNode next = currentListNode.next;
            currentListNode.next = previousListNode;
            previousListNode = currentListNode;
            currentListNode = next;

        }
        return previousListNode;
    }

    private ListNode getMiddlePointer(ListNode header) {
        ListNode slow = header;
        ListNode fast = header;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
