package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.Stack;

/**
 * 还原二进制搜索树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/02
 */
public class RestoreBinarySearchTree {
    public static class BinarySearchTreeNode {
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

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

    BinarySearchTreeNode firstErrorTreeNodePoint = null;
    BinarySearchTreeNode secondErrorTreeNodePoint = null;

    public void mySelf_RecordErrorPointRestoreBinarySearchTree(BinarySearchTreeNode root) {
        if (root == null) {
            return;
        }


        this.middleOrderTraversalFindErrorPoint(root);
        this.swapBinarySearchTreeNodeValue(firstErrorTreeNodePoint, secondErrorTreeNodePoint);

    }

    private void swapBinarySearchTreeNodeValue(BinarySearchTreeNode firstErrorTreeNodePoint, BinarySearchTreeNode secondErrorTreeNodePoint) {
        int temporaryFirstErrorTreeNodePointValue = firstErrorTreeNodePoint.value;
        firstErrorTreeNodePoint.value = secondErrorTreeNodePoint.value;
        secondErrorTreeNodePoint.value = temporaryFirstErrorTreeNodePointValue;
    }

    private void middleOrderTraversalFindErrorPoint(BinarySearchTreeNode root) {
        Stack<BinarySearchTreeNode> temporaryTreeNodePoint = new Stack<>();
        BinarySearchTreeNode currentTreeNodePoint = root;
        BinarySearchTreeNode previousTreeNodePoint = null;
        while (!temporaryTreeNodePoint.isEmpty() || currentTreeNodePoint != null) {
            while (currentTreeNodePoint != null) {
                temporaryTreeNodePoint.push(currentTreeNodePoint);
                currentTreeNodePoint = currentTreeNodePoint.leftTreeNode;
            }
            currentTreeNodePoint = temporaryTreeNodePoint.pop();
            if (previousTreeNodePoint != null && currentTreeNodePoint.value < previousTreeNodePoint.value) {
                if (firstErrorTreeNodePoint == null) {
                    firstErrorTreeNodePoint = previousTreeNodePoint;
                    secondErrorTreeNodePoint = currentTreeNodePoint;
                } else {
                    secondErrorTreeNodePoint = currentTreeNodePoint;
                }
            }
            previousTreeNodePoint = currentTreeNodePoint;
            currentTreeNodePoint = currentTreeNodePoint.rightTreeNode;
        }
    }
}
