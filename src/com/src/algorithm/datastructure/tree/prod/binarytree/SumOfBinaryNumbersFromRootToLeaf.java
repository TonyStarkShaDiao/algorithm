package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Stack;

/**
 * 从根到叶的二进制数之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/01
 */
public class SumOfBinaryNumbersFromRootToLeaf {
    public static class TreeNode {
        public int value;
        public TreeNode leftTreeNode;
        public TreeNode rightTreeNode;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.value = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.leftTreeNode = left;
            this.rightTreeNode = right;
        }
    }

    public int preorderTraversalSumOfBinaryNumbersFromRootToLeaf(TreeNode root) {
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<>();
        TreeNode currentTreeNode = root;
        TreeNode previousTreeNode = null;
        int currentSum = 0;
        int totalSum = 0;
        while (currentTreeNode != null || !temporaryTreeNodePointStack.isEmpty()) {
            while (currentTreeNode != null) {
                currentSum = (currentSum * 2) + (currentTreeNode.value);
                temporaryTreeNodePointStack.push(currentTreeNode);
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
            currentTreeNode = temporaryTreeNodePointStack.peek();
            if (currentTreeNode.rightTreeNode == null || currentTreeNode.rightTreeNode == previousTreeNode) {
                if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
                    totalSum += currentSum;
                }
                currentSum = currentSum / 2;
                temporaryTreeNodePointStack.pop();
                previousTreeNode = currentTreeNode;
                currentTreeNode = null;

            } else {
                currentTreeNode = currentTreeNode.rightTreeNode;
            }

        }
        return totalSum;

    }
}

