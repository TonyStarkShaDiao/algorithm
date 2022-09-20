package com.src.algorithm.datastructure.nodes.prod;

/**
 * 在链表中倒数第k个节点
 * 链表中
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */

public class InLinkedListReciprocalKthNode {

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

    public ListNode mySelf_doublePointInLinkedListReciprocalKthNode(ListNode head, int target) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        while (fastPoint != null && target > 0) {
            fastPoint = fastPoint.next;
            target--;
        }
        while (fastPoint != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        return slowPoint;
    }
}
