package com.src.algorithm.datastructure.nodes.prod;

/**
 * 交换链表中节点
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/24
 */
public class ExchangeNodesInLinkedList {
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

    public ListNode doublePointExchangeNodesValueInLinkedList(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowListNodePoint = head;
        ListNode fastListNodePoint = head;
        ListNode currentListNodePoint = head;
        int linkedListIndex = 1;
        while (currentListNodePoint != null) {
            if (linkedListIndex < target) {
                fastListNodePoint = fastListNodePoint.next;
            } else {
                slowListNodePoint = slowListNodePoint.next;
            }
            currentListNodePoint = currentListNodePoint.next;
            linkedListIndex++;
        }
        int value = fastListNodePoint.value;
        fastListNodePoint.value = slowListNodePoint.value;
        slowListNodePoint.value = value;
        return head;
    }

}
