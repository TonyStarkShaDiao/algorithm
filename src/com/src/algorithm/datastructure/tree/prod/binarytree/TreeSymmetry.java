package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树对称
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/04
 */
public class TreeSymmetry {
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

    public Boolean mySelf_DequeDoublePointerSymmetry(TreeNode treeNodeRoot) {
        if (treeNodeRoot == null) {
            return true;
        }
        return dequeDoublePointerSymmetry(treeNodeRoot, treeNodeRoot);
    }

    private Boolean dequeDoublePointerSymmetry(TreeNode leftTreeNodeRoot, TreeNode rightTreeNodeRoot) {
        Queue<TreeNode> TemporaryTreeNodes = new LinkedList<>();
        TemporaryTreeNodes.add(leftTreeNodeRoot);
        TemporaryTreeNodes.add(rightTreeNodeRoot);
        while (!TemporaryTreeNodes.isEmpty()) {
            TreeNode leftTreeNode = TemporaryTreeNodes.poll();
            TreeNode rightTreeNode = TemporaryTreeNodes.poll();
            if (leftTreeNode == null && rightTreeNode == null) {
                continue;
            }
            if (leftTreeNode == null || rightTreeNode == null) {
                return false;
            }
            if (leftTreeNode.value != rightTreeNode.value) {
                return false;
            }
            TemporaryTreeNodes.add(leftTreeNode.leftTreeNode);
            TemporaryTreeNodes.add(rightTreeNode.rightTreeNode);
            TemporaryTreeNodes.add(rightTreeNode.leftTreeNode);
            TemporaryTreeNodes.add(leftTreeNode.rightTreeNode);
        }
        return true;
    }

    public Boolean mySelf_RecursiveDoublePointerSymmetry(TreeNode treeNodeRoot) {
        return RecursiveDoublePointerSymmetry(treeNodeRoot, treeNodeRoot);
    }

    private Boolean RecursiveDoublePointerSymmetry(TreeNode leftTreeNodeRoot, TreeNode rightTreeNodeRoot) {
        if (leftTreeNodeRoot == null && rightTreeNodeRoot == null) {
            return true;
        }
        if (leftTreeNodeRoot == null || rightTreeNodeRoot == null) {
            return false;
        }
        return leftTreeNodeRoot.value == rightTreeNodeRoot.value
                && RecursiveDoublePointerSymmetry(leftTreeNodeRoot.leftTreeNode, rightTreeNodeRoot.rightTreeNode)
                && RecursiveDoublePointerSymmetry(rightTreeNodeRoot.leftTreeNode, leftTreeNodeRoot.rightTreeNode);
    }
}
