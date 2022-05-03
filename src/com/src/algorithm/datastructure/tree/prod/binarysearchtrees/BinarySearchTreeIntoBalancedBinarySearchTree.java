package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树转化为平衡二叉搜索树
 * Binary search tree into balanced binary search tree
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/28
 */
public class BinarySearchTreeIntoBalancedBinarySearchTree {
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

    public BinarySearchTreeNode mySelf_ArrayBinarySearchTreeIntoBalancedBinarySearchTree(BinarySearchTreeNode needBalanceBinarySearchTreeNode) {

        Integer[] needBalanceBinarySearchTreeNodeArray = middleOrderTraversal(needBalanceBinarySearchTreeNode);
        BinarySearchTreeNode binarySearchTreeNode = orderArrayToBinarySearchTree(needBalanceBinarySearchTreeNodeArray, 0, needBalanceBinarySearchTreeNodeArray.length - 1);
        return binarySearchTreeNode;
    }

    private BinarySearchTreeNode orderArrayToBinarySearchTree(Integer[] needBalanceBinarySearchTreeNodeArray, int orderArrayStartIndex, int orderArrayEndArrayIndex) {
        if (orderArrayStartIndex > orderArrayEndArrayIndex) {
            return null;
        }
        int orderArrayMiddleIndex = orderArrayStartIndex + (orderArrayEndArrayIndex - orderArrayStartIndex) / 2;
        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode(needBalanceBinarySearchTreeNodeArray[orderArrayMiddleIndex]);
        binarySearchTreeNode.leftTreeNode = orderArrayToBinarySearchTree(needBalanceBinarySearchTreeNodeArray, orderArrayStartIndex, orderArrayMiddleIndex - 1);
        binarySearchTreeNode.rightTreeNode = orderArrayToBinarySearchTree(needBalanceBinarySearchTreeNodeArray, orderArrayMiddleIndex + 1, orderArrayEndArrayIndex);
        return binarySearchTreeNode;
    }

    private Integer[] middleOrderTraversal(BinarySearchTreeNode needBalanceBinarySearchTreeNode) {
        if (needBalanceBinarySearchTreeNode == null) {
            return null;
        }
        List<Integer> needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollect = new ArrayList<>();
        Stack<BinarySearchTreeNode> temporaryStack = new Stack<>();
        while (!temporaryStack.isEmpty() || needBalanceBinarySearchTreeNode != null) {
            while (needBalanceBinarySearchTreeNode != null) {
                temporaryStack.push(needBalanceBinarySearchTreeNode);
                needBalanceBinarySearchTreeNode = needBalanceBinarySearchTreeNode.leftTreeNode;
            }
            BinarySearchTreeNode currentBinBinarySearchTreeNode = temporaryStack.pop();
            needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollect.add(currentBinBinarySearchTreeNode.value);
            needBalanceBinarySearchTreeNode = currentBinBinarySearchTreeNode.rightTreeNode;

        }
        Integer[] needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollectArray = new Integer[needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollect.size()];
        return needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollect.toArray(needBalanceBinarySearchTreeNodeMiddleOrderTraversalCollectArray);
    }

}

