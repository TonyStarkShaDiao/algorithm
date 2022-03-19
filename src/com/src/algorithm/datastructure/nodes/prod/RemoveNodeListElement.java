package com.src.algorithm.datastructure.nodes.prod;

/**
 * 删除链表元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/17
 */
public class RemoveNodeListElement {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.value = val;
        }

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }

    /**
     * 我自己临时节点删除节点列表元素
     * 我自己的临时节点算法删除指定链表元素
     *
     * @param headerNodeList 头
     * @return {@link ListNode}
     */
    public ListNode mySelf_TemporaryNodeRemoveNodeListElement(ListNode headerNodeList, int element) {
        ListNode tempNode = new ListNode(0);
        tempNode.next = headerNodeList;
        ListNode tempHeaderNodeList = tempNode;
        while (tempHeaderNodeList.next != null) {
            if (tempHeaderNodeList.next.value == element) {
                tempHeaderNodeList.next=tempHeaderNodeList.next.next;
            } else {
                tempHeaderNodeList=tempHeaderNodeList.next;
            }
        }
        return tempNode.next;
    }
    public ListNode mySelf_RecursiveNodeListElement(ListNode headerNodeList, int element) {
        if (headerNodeList==null){
            return headerNodeList;
        }
        headerNodeList.next=mySelf_RecursiveNodeListElement(headerNodeList.next,element);
        return headerNodeList.value==element?headerNodeList.next:headerNodeList;
    }
}
