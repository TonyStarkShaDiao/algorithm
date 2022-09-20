package com.src.algorithm.datastructure.nodes.prod;

/**
 * 对链表排序
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */
public class SortLinkedList {
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

    public ListNode mySelf_mergeSortLinkedList(ListNode disorderListNodeHeader) {
        if (disorderListNodeHeader == null || disorderListNodeHeader.next == null) {
            return disorderListNodeHeader;
        }
        ListNode middlePointListNode = this.middlePointListNode(disorderListNodeHeader);
        ListNode leftListNode = this.mySelf_mergeSortLinkedList(disorderListNodeHeader);
        ListNode rightListNode = this.mySelf_mergeSortLinkedList(middlePointListNode);

        ListNode listNode = this.mergeLinkedList(leftListNode, rightListNode);
        return listNode;
    }

    private ListNode mergeLinkedList(ListNode firstListNode, ListNode secondListNode) {
        ListNode resultListNode = new ListNode(-1);
        ListNode resultListNodeHeader = resultListNode;
        while (firstListNode != null && secondListNode != null) {
            if (firstListNode.value <= secondListNode.value) {
                resultListNode.next = firstListNode;
                firstListNode = firstListNode.next;
            } else {
                resultListNode.next = secondListNode;
                secondListNode = secondListNode.next;
            }
            resultListNode = resultListNode.next;
        }
        resultListNode.next = firstListNode == null ? secondListNode : firstListNode;
        return resultListNodeHeader.next;
    }

    private ListNode middlePointListNode(ListNode disorderListNodeHeader) {
        ListNode slow = disorderListNodeHeader;
        ListNode fast = disorderListNodeHeader.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middlePoint = slow.next;
        slow.next = null;
        return middlePoint;
    }
}
