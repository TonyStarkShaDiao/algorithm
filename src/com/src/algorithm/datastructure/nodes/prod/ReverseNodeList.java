package com.src.algorithm.datastructure.nodes.prod;

/**
 * 反向链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/18
 */
public class ReverseNodeList {

    // Definition for singly-linked list.
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

//    public ListNode myself_TempNodeReverseNodeList(ListNode nodeHeader) {
//        ListNode previousNode = null;
//        ListNode tempNode = nodeHeader;
//        while (tempNode != null) {
//            ListNode nextNode = tempNode.next;
//            tempNode.next = previousNode;
//            previousNode = tempNode;
//            tempNode = nextNode;
//        }
//        return previousNode;
//    }
//    public ListNode myself_TempNodeReverseNodeList(ListNode nodeHeader) {
//        ListNode endNode =null;
//        ListNode tempNodeList= nodeHeader;
//        while (tempNodeList != null) {
//            ListNode iterationNodeList = tempNodeList.next;
//            tempNodeList.next=endNode;
//            endNode=tempNodeList;
//            tempNodeList=iterationNodeList;
//        }
//        return endNode;
//    }

    //    public ListNode myself_TempNodeReverseNodeList(ListNode nodeHeader) {
//        ListNode endNode = null;
//        while (nodeHeader != null) {
//            ListNode iterationNodes = nodeHeader.next;
//            nodeHeader.next = endNode;
//            endNode = nodeHeader;
//            nodeHeader = iterationNodes;
//        }
//        return endNode;
//    }
    public ListNode myself_TempNodeReverseNodeList(ListNode nodeHeader) {
        ListNode endNode = null;
        while (nodeHeader != null) {
            ListNode iterationNodeMemoryAddress = nodeHeader.next;
            nodeHeader.next = endNode;
            endNode = nodeHeader;
            nodeHeader = iterationNodeMemoryAddress;
        }
        return endNode;
    }

//    public ListNode myself_RecursiveNodeReverseNodeList(ListNode nodeHeaderMemoryAddress) {
//        if (nodeHeaderMemoryAddress == null || nodeHeaderMemoryAddress.next == null) {
//            return nodeHeaderMemoryAddress;
//        }
//        ListNode newListNodeMemoryAddress = myself_RecursiveNodeReverseNodeList(nodeHeaderMemoryAddress.next);
//        nodeHeaderMemoryAddress.next.next = nodeHeaderMemoryAddress;
//        nodeHeaderMemoryAddress.next = null;
//        return newListNodeMemoryAddress;
//    }
    public ListNode myself_RecursiveNodeReverseNodeList(ListNode nodeHeaderMemoryAddress) {
        while (nodeHeaderMemoryAddress == null || nodeHeaderMemoryAddress.next == null) {
            return nodeHeaderMemoryAddress;
        }
        ListNode childrenNodeMemoryAddress = myself_RecursiveNodeReverseNodeList(nodeHeaderMemoryAddress.next);
        nodeHeaderMemoryAddress.next.next = nodeHeaderMemoryAddress;
        nodeHeaderMemoryAddress.next = null;
        return childrenNodeMemoryAddress;
    }
}
