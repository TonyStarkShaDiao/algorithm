package com.src.algorithm.datastructure.nodes.prod;


public class OrderedLinkedListTransformationBinarySearchTree {
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

    public static class BinarySearchTreeNode {
        public int value;
        public BinarySearchTreeNode leftTreeNode;
        public BinarySearchTreeNode rightTreeNode;

        public BinarySearchTreeNode() {
        }

        public BinarySearchTreeNode(int val) {
            this.value = val;
        }

        public BinarySearchTreeNode(int val, BinarySearchTreeNode left, BinarySearchTreeNode right) {
            this.value = val;
            this.leftTreeNode = left;
            this.rightTreeNode = right;
        }
    }

    public BinarySearchTreeNode mySelf_searchDichotomyOrderedLinkedListTransformationBinarySearchTree(ListNode head) {
        if (head == null) {
            return null;
        }
        return this.searchDichotomyOrderedLinkedListTransformationBinarySearchTree(head, null);
    }

    private BinarySearchTreeNode searchDichotomyOrderedLinkedListTransformationBinarySearchTree(ListNode headerPointListNode, ListNode tailPointListNode) {
        if (headerPointListNode == tailPointListNode) {
            return null;
        }
        ListNode midPointListNode = this.getMidPointListNode(headerPointListNode, tailPointListNode);
        BinarySearchTreeNode midTreeNode = new BinarySearchTreeNode(midPointListNode.value);
        midTreeNode.leftTreeNode = this.searchDichotomyOrderedLinkedListTransformationBinarySearchTree(headerPointListNode, midPointListNode);
        midTreeNode.rightTreeNode = this.searchDichotomyOrderedLinkedListTransformationBinarySearchTree(midPointListNode.next, tailPointListNode);
        return midTreeNode;
    }

    private ListNode getMidPointListNode(ListNode headerPointListNode, ListNode tailPointListNode) {
        ListNode fastPointListNode = headerPointListNode;
        ListNode slowPointListNode = headerPointListNode;
        while (fastPointListNode != tailPointListNode && fastPointListNode.next != tailPointListNode) {
            fastPointListNode = fastPointListNode.next.next;
            slowPointListNode = slowPointListNode.next;
        }
        return slowPointListNode;
    }
}
