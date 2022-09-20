package com.src.algorithm.datastructure.nodes.prod;

/**
 * 奇偶链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/23
 */

public class OddEvenLinkedList {
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

    public ListNode mySelf_threePointerOddEvenLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currentOddListNodePoint = head;
        ListNode currentEvenListNodePoint = head.next;
        ListNode evenListNodeHeaderPoint = currentEvenListNodePoint;
        while (currentEvenListNodePoint != null && currentEvenListNodePoint.next != null) {
            currentOddListNodePoint.next = currentOddListNodePoint.next.next;
            currentOddListNodePoint = currentOddListNodePoint.next;
            currentEvenListNodePoint.next = currentEvenListNodePoint.next.next;
            currentEvenListNodePoint = currentEvenListNodePoint.next;
        }
        currentOddListNodePoint.next = evenListNodeHeaderPoint;
        return head;
    }
}
