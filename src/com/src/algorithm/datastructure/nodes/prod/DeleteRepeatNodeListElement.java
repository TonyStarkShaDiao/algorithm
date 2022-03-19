package com.src.algorithm.datastructure.nodes.prod;

/**
 * 删除重复链表元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/19
 */
public class DeleteRepeatNodeListElement {

    // * Definition for singly-linked list.
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.value = val;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }


    public ListNode myself_IterationDeleteRepeatNodeListElement(ListNode headerNodeList) {
        if (headerNodeList == null || headerNodeList.next == null) {
            return headerNodeList;
        }
        ListNode tempNode = headerNodeList;
        while (tempNode.next != null) {
            if (tempNode.value == tempNode.next.value) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return headerNodeList;
    }
}
