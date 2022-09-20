package com.src.algorithm.datastructure.nodes.prod;

/**
 * 给单链表加1
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/24
 */
public class AddOneToSingleLinkedList {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }

    public ListNode mySelf_reverseLinkedListAddOneToSingleLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        head = this.reverseLinedList(head);
        ListNode dummyListNode = new ListNode(0);
        dummyListNode.next = head;
        ListNode currentPointer = dummyListNode;
        int carryValue = 0;
        int addOne = 1;
        while (currentPointer != null) {
            if (addOne != 1) {
                addOne = 0;
            }
            int sum = currentPointer.next.value + carryValue + addOne;
            addOne--;
            carryValue = sum / 10;
            currentPointer.next.value = sum % 10;
            currentPointer = currentPointer.next;
        }
        if (carryValue != 0) {
            ListNode ComplementListNode = new ListNode(carryValue);
            currentPointer.next = ComplementListNode;
        }
        head = this.reverseLinedList(dummyListNode.next);
        return head;

    }

    private ListNode reverseLinedList(ListNode head) {
        ListNode previousPointer = null;
        ListNode currentPointer = head;
        while (currentPointer != null) {
            ListNode nextPointer = currentPointer.next;
            currentPointer.next = previousPointer;
            previousPointer = currentPointer;
            currentPointer = nextPointer;
        }
        return previousPointer;
    }
}
