package com.src.algorithm.datastructure.nodes.prod;

/**
 * 反向链表ii
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/21
 */
public class ReverseLinkedListII {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }
    }

    public ListNode mySelf_reverse(ListNode head, int reverseStartElement, int reverseEndElement) {
        if (head == null || head.next == null || reverseStartElement == reverseEndElement) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head != null) {
            if (head.value == reverseStartElement - 1) {
                ListNode reverse = this.reverse(head, reverseEndElement);
                head.next = reverse;
                break;
            }
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int reverseEndElement) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur.value == reverseEndElement + 1) {
                pre.next = cur.next;
                break;
            }
        }
        return pre;
    }

    public ListNode mySelf_doublePointReverse(ListNode head, int reverseStartElement, int reverseEndElement) {
        if (head == null || head.next == null || reverseStartElement == reverseEndElement) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousListNode = dummy;
        for (int linkedListIndex = 0; linkedListIndex < reverseStartElement - 1; linkedListIndex++) {
            previousListNode = previousListNode.next;
        }
        ListNode currentListNode = previousListNode.next;
        for (int linkedListIndex = 0; linkedListIndex < reverseEndElement - reverseStartElement; linkedListIndex++) {
            ListNode nextListNode = currentListNode.next;
            currentListNode.next = nextListNode.next;
            nextListNode.next = previousListNode.next;
            previousListNode.next = nextListNode;
        }
        return dummy.next;
    }


}
