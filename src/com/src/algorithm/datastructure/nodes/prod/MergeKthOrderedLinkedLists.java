package com.src.algorithm.datastructure.nodes.prod;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并k个有序链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/23
 */
public class MergeKthOrderedLinkedLists {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
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

    public ListNode MySelf_DivideAndConquerMergeKthOrderedLinkedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return this.divideAndConquerMerge(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquerMerge(ListNode[] lists, int headerPoint, int tailPoint) {
        if (headerPoint == tailPoint) {
            return lists[headerPoint];
        }
        int mid = headerPoint + ((tailPoint - headerPoint) >> 1);
        ListNode headerPointBoundaryListNode = divideAndConquerMerge(lists, headerPoint, mid);
        ListNode tailPointBoundaryListNode = divideAndConquerMerge(lists, mid + 1, tailPoint);
        return this.mergeLinkedList(headerPointBoundaryListNode, tailPointBoundaryListNode);
    }

    private ListNode mergeLinkedList(ListNode firstOneListNode, ListNode secondOneListNode) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (firstOneListNode != null && secondOneListNode != null) {
            if (firstOneListNode.value < secondOneListNode.value) {
                temp.next = firstOneListNode;
                firstOneListNode = firstOneListNode.next;
            } else {
                temp.next = secondOneListNode;
                secondOneListNode = secondOneListNode.next;
            }
            temp = temp.next;
        }
        temp.next = firstOneListNode == null ? secondOneListNode : firstOneListNode;
        return dummyHead.next;
    }

    public ListNode MySelf_miniHeapMergeKthOrderedLinkedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> miniHeap = new PriorityQueue<>((firstOneListNode, secondOneListNode) -> firstOneListNode.value - secondOneListNode.value);
        for (ListNode listNode : lists) {
            while (listNode != null) {
                miniHeap.offer(listNode);
                listNode = listNode.next;
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (miniHeap.size() > 0) {
            ListNode currentMiniListNode = miniHeap.poll();
            temp.next = currentMiniListNode;
            temp = temp.next;
            if (miniHeap.size() > 0) {
                temp.next = null;
            }
        }
        return dummyHead.next;
    }
}
