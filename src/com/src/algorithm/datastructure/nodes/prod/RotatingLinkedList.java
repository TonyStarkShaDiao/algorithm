package com.src.algorithm.datastructure.nodes.prod;

public class RotatingLinkedList {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof ListNode) {
                ListNode node = (ListNode) obj;
                ListNode tempListNode = new ListNode(value);
                tempListNode.next = next;
                while (node != null) {
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

    public ListNode mySelf_doublePointRotatingLinkedList(ListNode beforeRotationListNodeHeader, int numberOfRotations) {
        if (beforeRotationListNodeHeader == null || beforeRotationListNodeHeader.next == null) {
            return null;
        }
        int linkedListLength = 0;
        ListNode temporaryBeforeRotationListNodeHeader = beforeRotationListNodeHeader;
        while (temporaryBeforeRotationListNodeHeader != null) {
            linkedListLength++;
            temporaryBeforeRotationListNodeHeader = temporaryBeforeRotationListNodeHeader.next;
        }
        int rotationLength = numberOfRotations % linkedListLength;
        if (rotationLength == 0) {
            return beforeRotationListNodeHeader;
        }
        ListNode fastPointer = beforeRotationListNodeHeader;
        ListNode slowPointer = beforeRotationListNodeHeader;
        for (int i = 0; i < rotationLength; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        ListNode newHead = slowPointer.next;
        slowPointer.next = null;
        fastPointer.next = beforeRotationListNodeHeader;
        return newHead;
    }
}
