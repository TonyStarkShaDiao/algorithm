package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.Deque;
import java.util.Stack;

public class BinarySearchTreeIterator {
    private BinarySearchTreeNode root;
    private Stack<BinarySearchTreeNode> stack;

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

    public BinarySearchTreeIterator(BinarySearchTreeNode root) {
        if (root == null) {
            return;
        }
        this.root = root;
        stack = new Stack<BinarySearchTreeNode>();
    }

    public int next() {
        while (root != null) {
            stack.push(root);
            root = root.leftTreeNode;
        }
        BinarySearchTreeNode popCurrentTreeNode = stack.pop();
        root = popCurrentTreeNode.rightTreeNode;
        return popCurrentTreeNode.value;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}
