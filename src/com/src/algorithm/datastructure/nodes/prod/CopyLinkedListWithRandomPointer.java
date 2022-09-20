package com.src.algorithm.datastructure.nodes.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用随机指针复制链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */
public class CopyLinkedListWithRandomPointer {
    public ListNode MySelf_iterationCopyLinkedListWithRandomPointer(ListNode oldHeader) {
        if (oldHeader == null) {
            return null;
        }
        Map<ListNode, ListNode> map = new HashMap<>();
        for (ListNode currentListNode = oldHeader; currentListNode != null; currentListNode = currentListNode.next) {
            map.put(currentListNode, new ListNode(currentListNode.value));
        }
        for (ListNode currentListNode = oldHeader; currentListNode != null; currentListNode = currentListNode.next) {
            map.get(currentListNode).next = map.get(currentListNode.next);
            map.get(currentListNode).randomNext = map.get(currentListNode.randomNext);
        }
        return map.get(oldHeader);
    }

    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode randomNext;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }
}
