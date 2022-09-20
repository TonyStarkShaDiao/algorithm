package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 判断是否为高度平衡二叉树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/25
 */
public class JudgeWhetherItIsAHighlyBalancedBinaryTree {
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

    public boolean mySelf_middleOrderTraversalJudgeWhetherItIsAHighlyBalancedBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<>();
        TreeNode currentTreeNode = root;
        while (currentTreeNode != null || !temporaryTreeNodePointStack.isEmpty()) {
            while (currentTreeNode != null) {
                temporaryTreeNodePointStack.push(currentTreeNode);
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
            TreeNode currentPopTreeNodePoint = temporaryTreeNodePointStack.pop();
            int leftTreeNodeHeight = this.getTreeNodeHeight(currentPopTreeNodePoint.leftTreeNode);
            int rightTreeNodeHeight = this.getTreeNodeHeight(currentPopTreeNodePoint.rightTreeNode);
            if (Math.abs(leftTreeNodeHeight - rightTreeNodeHeight) > 1) {
                return false;
            }
            currentTreeNode = currentPopTreeNodePoint.rightTreeNode;
        }
        return true;
    }

    private int getTreeNodeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> temporaryTreeNodePointQueue = new ArrayDeque<>();
        temporaryTreeNodePointQueue.add(root);
        int height = 0;
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            int size = temporaryTreeNodePointQueue.size();
            height++;
            while (size-- > 0) {
                TreeNode currentTreeNode = temporaryTreeNodePointQueue.poll();
                if (currentTreeNode.leftTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.rightTreeNode);
                }
            }
        }
        return height;
    }
}
