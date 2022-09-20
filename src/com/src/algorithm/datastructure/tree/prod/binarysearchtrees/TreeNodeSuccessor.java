package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.Stack;

/**
 * 树节点后继节点
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/16
 */
public class TreeNodeSuccessor {
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

    public BinarySearchTreeNode mySelf_DichotomySuccessor(BinarySearchTreeNode root, BinarySearchTreeNode targetTreeNode) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode successorTreeNode = null;
        if (targetTreeNode.rightTreeNode != null) {
            successorTreeNode = targetTreeNode.rightTreeNode;
            while (successorTreeNode.leftTreeNode != null) {
                successorTreeNode = successorTreeNode.leftTreeNode;
            }

            return successorTreeNode;
        }
        BinarySearchTreeNode currentTreeNode = root;
        while (currentTreeNode != null) {
            if (currentTreeNode.value > targetTreeNode.value) {
                successorTreeNode = currentTreeNode;
                currentTreeNode = currentTreeNode.leftTreeNode;
            } else {
                currentTreeNode = currentTreeNode.rightTreeNode;
            }
        }
        return successorTreeNode;
    }

    public BinarySearchTreeNode mySelf_previousTreeNodeSuccessor(BinarySearchTreeNode root, BinarySearchTreeNode targetTreeNode) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode currentTreeNode = root;
        BinarySearchTreeNode previousTreeNode = null;
        Stack<BinarySearchTreeNode> binarySearchTreeNodeStack = new Stack<>();
        while (currentTreeNode != null || !binarySearchTreeNodeStack.isEmpty()) {
            while (currentTreeNode != null) {
                binarySearchTreeNodeStack.push(currentTreeNode);
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
            currentTreeNode = binarySearchTreeNodeStack.pop();
            if (previousTreeNode == targetTreeNode) {
                return currentTreeNode;
            }
            previousTreeNode = currentTreeNode;
            currentTreeNode = currentTreeNode.rightTreeNode;
        }
        return null;
    }

    public BinarySearchTreeNode mySelf_booleanSuccessor(BinarySearchTreeNode root, BinarySearchTreeNode targetTreeNode) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode currentTreeNode = root;
        Stack<BinarySearchTreeNode> temporaryStack = new Stack<BinarySearchTreeNode>();
        boolean isfind = false;
        while (currentTreeNode != null || !temporaryStack.isEmpty()) {
            while (currentTreeNode != null) {
                temporaryStack.push(currentTreeNode);
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
            currentTreeNode = temporaryStack.pop();
            if (isfind) {
                return currentTreeNode;
            }
            if (currentTreeNode == targetTreeNode) {
                isfind = true;
            }
            currentTreeNode = currentTreeNode.rightTreeNode;
        }
        return null;
    }
}
