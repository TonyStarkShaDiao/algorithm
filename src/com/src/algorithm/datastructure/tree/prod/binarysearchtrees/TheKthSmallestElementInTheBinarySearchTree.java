package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中第k个最小元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/05
 */
public class TheKthSmallestElementInTheBinarySearchTree {
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

    public int mySelf_middleOrderTraversalTheKthSmallestElementInTheBinarySearchTree(BinarySearchTreeNode root, int findElement) {
        List<Integer> treeNodeElementCollect = new ArrayList<>();
        this.middleOrderTraversal(root, treeNodeElementCollect);
        return treeNodeElementCollect.get(findElement - 1);
    }

    private void middleOrderTraversal(BinarySearchTreeNode root, List<Integer> treeNodeElementCollect) {
        BinarySearchTreeNode currentNode = root;
        Stack<BinarySearchTreeNode> temporary = new Stack<>();
        while (currentNode != null || !temporary.isEmpty()) {
            while (currentNode != null) {
                temporary.push(currentNode);
                currentNode = currentNode.leftTreeNode;
            }
            BinarySearchTreeNode popCurrent = temporary.pop();
            treeNodeElementCollect.add(popCurrent.value);
            currentNode = popCurrent.rightTreeNode;
        }
    }
}
