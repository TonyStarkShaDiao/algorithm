package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Stack;

/**
 * 单值二叉树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/24
 */
public class SingleValuedBinaryTree {

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

    public boolean mySelf_middleOrderTraversalSingleValuedBinaryTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        int currentValue = root.value;
        Stack<TreeNode> temporary = new Stack<>();
        TreeNode current = root;
        while (current != null || !temporary.isEmpty()) {
            while (current != null) {
                temporary.push(current);
                current = current.leftTreeNode;
            }
            TreeNode currentTreeNode = temporary.pop();
            if (currentTreeNode.value != currentValue) {
                return false;
            }
            current = currentTreeNode.rightTreeNode;
        }
        return true;
    }
}
