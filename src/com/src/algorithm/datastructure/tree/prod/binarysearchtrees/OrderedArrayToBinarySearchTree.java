package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有序数组转二叉搜索树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/28
 */
public class OrderedArrayToBinarySearchTree {
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

    public BinarySearchTreeNode mySelf_middleOrderTraversalBuildBinarySearchTree(int[] orderArray) {
        if (orderArray.length == 0) {
            return null;
        }
        BinarySearchTreeNode binarySearchTreeNodeRootPoint = this.creatCompleteBinaryTree(orderArray.length);
        BinarySearchTreeNode currentBinarySearchTreeNodePoint = binarySearchTreeNodeRootPoint;
        Stack<BinarySearchTreeNode> temporaryTreeNodePointStack = new Stack<>();
        int currentArrayIndex = 0;
        while (currentBinarySearchTreeNodePoint != null || !temporaryTreeNodePointStack.isEmpty()) {
            while (currentBinarySearchTreeNodePoint != null) {
                temporaryTreeNodePointStack.push(currentBinarySearchTreeNodePoint);
                currentBinarySearchTreeNodePoint = currentBinarySearchTreeNodePoint.leftTreeNode;
            }
            if (!temporaryTreeNodePointStack.isEmpty()) {
                currentBinarySearchTreeNodePoint = temporaryTreeNodePointStack.pop();
                currentBinarySearchTreeNodePoint.value = orderArray[currentArrayIndex++];
                currentBinarySearchTreeNodePoint = currentBinarySearchTreeNodePoint.rightTreeNode;

            }
        }
        return binarySearchTreeNodeRootPoint;

    }

    private BinarySearchTreeNode creatCompleteBinaryTree(int orderArrayLength) {
        if (orderArrayLength == 0) {
            return null;
        } else {
            int currentTreeNodeValue = 0;
            BinarySearchTreeNode binarySearchRoot = new BinarySearchTreeNode(currentTreeNodeValue++);
            BinarySearchTreeNode currentBinarySearchTreeNodePoint = binarySearchRoot;
            Queue<BinarySearchTreeNode> temporaryTreeNodePointQueue = new LinkedList<>();
            temporaryTreeNodePointQueue.add(binarySearchRoot);
            while (currentTreeNodeValue < orderArrayLength && !temporaryTreeNodePointQueue.isEmpty()) {
                currentBinarySearchTreeNodePoint = temporaryTreeNodePointQueue.poll();
                currentBinarySearchTreeNodePoint.leftTreeNode = new BinarySearchTreeNode(currentTreeNodeValue);
                temporaryTreeNodePointQueue.add(currentBinarySearchTreeNodePoint.leftTreeNode);
                if (++currentTreeNodeValue >= orderArrayLength) {
                    return binarySearchRoot;
                }
                currentBinarySearchTreeNodePoint.rightTreeNode = new BinarySearchTreeNode(currentTreeNodeValue);
                temporaryTreeNodePointQueue.add(currentBinarySearchTreeNodePoint.rightTreeNode);
                if (++currentTreeNodeValue >= orderArrayLength) {
                    return binarySearchRoot;
                }
            }
            return binarySearchRoot;
        }
    }

    public BinarySearchTreeNode Myself_RecursionOrderedArrayToBinarySearchTree(int[] orderArray) {
        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode();
        binarySearchTreeNode = this.buildSingledBinarySearchTreeNode(orderArray, 0, orderArray.length - 1);
        return binarySearchTreeNode;
    }

    BinarySearchTreeNode buildSingledBinarySearchTreeNode(int[] orderArray, int orderStartIndex, int orderEndIndex) {
        if (orderStartIndex > orderEndIndex) {
            return null;
        }
        int orderArrayCenterIndex = orderStartIndex + (orderEndIndex - orderStartIndex) / 2;
        BinarySearchTreeNode treeNodeRoot = new BinarySearchTreeNode(orderArray[orderArrayCenterIndex]);
        treeNodeRoot.leftTreeNode = this.buildSingledBinarySearchTreeNode(orderArray, orderStartIndex, orderArrayCenterIndex - 1);
        treeNodeRoot.rightTreeNode = this.buildSingledBinarySearchTreeNode(orderArray, orderArrayCenterIndex + 1, orderEndIndex);
        return treeNodeRoot;
    }

    public Boolean middleOrderTraversalCheckBinarySearchTree(BinarySearchTreeNode binarySearchTreeNode) {
        Stack<BinarySearchTreeNode> TemporaryBinarySearchTreeNode = new Stack<>();
        int currentMinValue = Integer.MIN_VALUE;
        while (binarySearchTreeNode != null || !TemporaryBinarySearchTreeNode.isEmpty()) {
            while (binarySearchTreeNode != null) {
                TemporaryBinarySearchTreeNode.add(binarySearchTreeNode);
                binarySearchTreeNode = binarySearchTreeNode.leftTreeNode;
            }
            BinarySearchTreeNode currentBinarySearchTreeNode = TemporaryBinarySearchTreeNode.pop();
            if (currentBinarySearchTreeNode.value <= currentMinValue) {
                return false;
            }
            currentMinValue = currentBinarySearchTreeNode.value;
            currentBinarySearchTreeNode = currentBinarySearchTreeNode.rightTreeNode;
        }
        return true;
    }
}
