package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {
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

    public int mySelf_levelTraversalMinimumDepthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> temporaryTreeNodePointQueue = new ArrayDeque<>();
        temporaryTreeNodePointQueue.add(root);
        int levelDepth = 0;
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            int currentTreeNodeLevel = temporaryTreeNodePointQueue.size();
            levelDepth++;
            for (int i = 0; i < currentTreeNodeLevel; i++) {
                TreeNode currentTreeNode = temporaryTreeNodePointQueue.poll();
                if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
                    return currentTreeNodeLevel;
                }
                if (currentTreeNode.leftTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.rightTreeNode);
                }
            }
        }
        return -1;
    }
}
