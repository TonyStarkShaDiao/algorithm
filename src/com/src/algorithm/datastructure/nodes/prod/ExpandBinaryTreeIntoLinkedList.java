package com.src.algorithm.datastructure.nodes.prod;

import java.util.Stack;

/**
 * 将二叉树展开到链表中
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/23
 */
public class ExpandBinaryTreeIntoLinkedList {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void mySelf_middleOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> temporaryTreeNodeElementStack = new Stack<>();
        temporaryTreeNodeElementStack.push(root);
        TreeNode previousTreeNode = null;
        while (!temporaryTreeNodeElementStack.isEmpty()) {
            TreeNode currentTreeNode = temporaryTreeNodeElementStack.pop();
            if (previousTreeNode != null) {
                previousTreeNode.left = null;
                previousTreeNode.right = currentTreeNode;
            }
            TreeNode nextLeftTreeNode = currentTreeNode.left;
            TreeNode nextRightTreeNode = currentTreeNode.right;
            if (nextRightTreeNode != null) {
                temporaryTreeNodeElementStack.push(nextRightTreeNode);
            }
            if (nextLeftTreeNode != null) {
                temporaryTreeNodeElementStack.push(nextLeftTreeNode);
            }
            previousTreeNode = currentTreeNode;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


}
