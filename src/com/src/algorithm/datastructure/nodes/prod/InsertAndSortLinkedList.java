package com.src.algorithm.datastructure.nodes.prod;

/**
 * 使用插入排序链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */
public class InsertAndSortLinkedList {
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

    public ListNode mySelf_InsertAndSortLinkedList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode notSortedPoint = head;
        ListNode currentPoint = head.next;
        while (currentPoint != null) {
            if (notSortedPoint.value <= currentPoint.value) {
                notSortedPoint = notSortedPoint.next;
            } else {
                ListNode previousListNodePoint = dummy;
                while (previousListNodePoint.next.value < currentPoint.value) {
                    previousListNodePoint = previousListNodePoint.next;
                }
                notSortedPoint.next = currentPoint.next;//2>1>6>7  2>6>7
                currentPoint.next = previousListNodePoint.next; //cuurent 1>>6>>7  current1>>2>>6>>7
                previousListNodePoint.next = currentPoint;  //pr 0>>2>>6>>7 pr 0>>1>>2>>6>>7
                System.out.println();

            }
            currentPoint = notSortedPoint.next;
        }
        return dummy.next;
    }
}
