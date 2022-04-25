package com.src.algorithm.datastructure.nodes.prod;

import java.util.List;

/**
 * 交叉链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/22
 */
public class IntersectingLinkedList {
    public static class ListNode {
        public int index;
        public ListNode next;


        public ListNode(int index) {
            this.index = index;
            next = null;
        }
    }

    public ListNode mySelf_LoveIntersectingLinkedList(ListNode firstOneHeaderListNode, ListNode secondOneHeaderListNode) {
        ListNode firstOneHeader = firstOneHeaderListNode;
        ListNode secondOneHeader = secondOneHeaderListNode;
        while (firstOneHeader != secondOneHeader) {
            firstOneHeader = firstOneHeader == null ? secondOneHeaderListNode : firstOneHeader.next;
            secondOneHeader = secondOneHeader == null ? firstOneHeaderListNode : secondOneHeader.next;
        }
        return firstOneHeader;
    }
}
