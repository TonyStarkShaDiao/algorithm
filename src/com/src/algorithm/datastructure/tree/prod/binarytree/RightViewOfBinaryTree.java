package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

/**
 * 二叉树右视图
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/03
 */
public class RightViewOfBinaryTree {

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode leftTreeNode = (TreeNode) o;
            TreeNode rightTreeNode = (TreeNode) o;
            TreeNode thisLeftTreeNode = this;
            TreeNode thisRightTreeNode = this;
//            this.treeNodeToArray
            while (leftTreeNode != null || thisLeftTreeNode != null) {
                if (leftTreeNode == null && thisLeftTreeNode != null) {
                    return false;
                }
                if (leftTreeNode != null && thisLeftTreeNode == null) {
                    return false;
                }
                if (thisLeftTreeNode.value != leftTreeNode.value) {
                    return false;
                }
                leftTreeNode = leftTreeNode.leftTreeNode;
                thisLeftTreeNode = thisLeftTreeNode.leftTreeNode;

            }
            while (rightTreeNode != null && thisRightTreeNode != null) {
                if (thisRightTreeNode.value != rightTreeNode.value) {
                    return false;
                }
                rightTreeNode = rightTreeNode.rightTreeNode;
                thisRightTreeNode = thisRightTreeNode.rightTreeNode;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, leftTreeNode, rightTreeNode);
        }
    }

    public List<Integer> mySelf_BFSRightViewOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultElementCollect = new ArrayList<>();
        Deque<TreeNode> temporaryTreeNodeDeque = new ArrayDeque<>();
        temporaryTreeNodeDeque.add(root);
        while (!temporaryTreeNodeDeque.isEmpty()) {
            int level = temporaryTreeNodeDeque.size();
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = temporaryTreeNodeDeque.poll();
                if (currentTreeNode.leftTreeNode != null) {
                    temporaryTreeNodeDeque.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    temporaryTreeNodeDeque.add(currentTreeNode.rightTreeNode);
                }
                if (i == level - 1) {
                    resultElementCollect.add(currentTreeNode.value);
                }
            }

        }
        return resultElementCollect;
    }
}
