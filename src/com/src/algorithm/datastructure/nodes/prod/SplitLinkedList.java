package com.src.algorithm.datastructure.nodes.prod;

public class SplitLinkedList {
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

    public ListNode mySelf_splitLinkedList(ListNode head, int target) {
        ListNode lessThanTargetListNodeDummy = new ListNode(0);
        ListNode lessThanTargetListNode = lessThanTargetListNodeDummy;
        ListNode greaterThanTargetListNodeDummy = new ListNode(0);
        ListNode greaterThanTargetListNode = greaterThanTargetListNodeDummy;
        while (head != null) {
            if (head.value < target) {
                lessThanTargetListNodeDummy.next = head;
                lessThanTargetListNodeDummy = lessThanTargetListNodeDummy.next;
            } else {
                greaterThanTargetListNodeDummy.next = head;
                greaterThanTargetListNodeDummy = greaterThanTargetListNodeDummy.next;
            }
            head = head.next;
        }
        greaterThanTargetListNodeDummy.next = null;
        lessThanTargetListNodeDummy.next = greaterThanTargetListNode.next;
        return lessThanTargetListNode.next;
    }
}
