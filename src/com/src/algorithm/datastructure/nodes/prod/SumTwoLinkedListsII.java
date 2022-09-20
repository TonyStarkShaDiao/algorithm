package com.src.algorithm.datastructure.nodes.prod;

/**
 * 两个链表之和ii
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/24
 */
public class SumTwoLinkedListsII {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public ListNode reversalSumTwoLinkedLists(ListNode firstOneListNode, ListNode secondOneListNode) {
        ListNode reversFirstOneListNode = this.reversLinedList(firstOneListNode);
        ListNode reversSecondOneListNode = this.reversLinedList(secondOneListNode);
        ListNode reversNewListNode = new ListNode(0);
        ListNode currentReversNewListNodeHeader = reversNewListNode;
        int carryValue = 0;
        while (reversFirstOneListNode != null || reversSecondOneListNode != null) {
            int firstOneListNodeValue = reversFirstOneListNode == null ? 0 : reversFirstOneListNode.value;
            int secondOneListNodeValue = reversSecondOneListNode == null ? 0 : reversSecondOneListNode.value;
            int sum = firstOneListNodeValue + secondOneListNodeValue + carryValue;
            carryValue = sum / 10;
            currentReversNewListNodeHeader.next = new ListNode(sum % 10);
            currentReversNewListNodeHeader = currentReversNewListNodeHeader.next;
            reversFirstOneListNode = reversFirstOneListNode == null ? null : reversFirstOneListNode.next;
            reversSecondOneListNode = reversSecondOneListNode == null ? null : reversSecondOneListNode.next;
        }
        if (carryValue > 0) {
            currentReversNewListNodeHeader.next = new ListNode(carryValue);
        }
        ListNode newHeaderListNode = this.reversLinedList(reversNewListNode.next);
        return newHeaderListNode;
    }

    private ListNode reversLinedList(ListNode header) {
        ListNode pre = null;
        ListNode cur = header;
        while (cur != null) {
            ListNode currentListNodeNextPoint = cur.next;
            cur.next = pre;
            pre = cur;
            cur = currentListNodeNextPoint;
        }
        return pre;
    }
}
