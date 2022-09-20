package com.src.algorithm.datastructure.nodes.prod;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/16
 *
 */

public class CircularLinkedList {

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

    /**
     * 自己的hash计数法
     * 执行用时：5 ms
     * 内存消耗:42 MB
     *
     * @return {@link Boolean}
     */
    public Boolean myself_HashCount(ListNode nodeHeader) {
        if (nodeHeader == null || nodeHeader.next == null) {
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (nodeHeader != null) {
            if (!nodeSet.add(nodeHeader)) {
                return true;
            }
            nodeHeader = nodeHeader.next;
        }
        return false;
    }

    /**
     * 自己的快慢指针
     *
     * @param nodeHeader 节点头
     * @return {@link Boolean}
     */
    public Boolean myself_FastSlowPointer(ListNode nodeHeader) {
        if (nodeHeader == null || nodeHeader.next == null) {
            return false;
        }
        ListNode fastPointer = nodeHeader;
        ListNode slowPointer = nodeHeader;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

}

