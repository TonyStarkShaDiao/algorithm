package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 树子结构
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/21
 */
public class SubstructureOfTree {
    public static class TreeNode {
        /**
         * 价值
         */
        public int value;
        /**
         * 左树节点
         */
        public TreeNode leftTreeNodePoint;
        /**
         * 右树节点
         */
        public TreeNode rightTreeNodePoint;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.value = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.leftTreeNodePoint = left;
            this.rightTreeNodePoint = right;
        }
    }

    public boolean mySelf_preorderTraversalJudgeIsSubtree(TreeNode root, TreeNode subTreeRoot) {
        if (root == null) {
            return false;
        }
        if (subTreeRoot == null) {
            return true;
        }
        boolean flag = true;
        Stack<TreeNode> temporaryMainTreePointStack = new Stack<>();
        while (root != null || !temporaryMainTreePointStack.isEmpty()) {
            while (root != null) {
                if (root.value == subTreeRoot.value) {
                    flag = this.compareWhetherIndexTreeIsSubtree(root, subTreeRoot);
                }
                temporaryMainTreePointStack.push(root);
                root = root.leftTreeNodePoint;
            }
            TreeNode currentMainTreeNode = temporaryMainTreePointStack.pop();
            root = currentMainTreeNode.rightTreeNodePoint;
        }
        return flag;
    }

    private boolean compareWhetherIndexTreeIsSubtree(TreeNode root, TreeNode subTreeRoot) {
        Deque<TreeNode> temporarymainTreePointQueue = new LinkedList<>();
        Deque<TreeNode> temporarySubTreePointQueue = new LinkedList<>();
        temporarymainTreePointQueue.add(root);
        temporarySubTreePointQueue.add(subTreeRoot);
        while (!temporarymainTreePointQueue.isEmpty() && !temporarySubTreePointQueue.isEmpty()) {
            int temporaryMainTreePointQueueSize = temporarymainTreePointQueue.size();
            int temporarySubTreePointQueueSize = temporarySubTreePointQueue.size();
            while (temporaryMainTreePointQueueSize-- > 0 && temporarySubTreePointQueueSize-- > 0) {
                TreeNode currentMainTreeNode = temporarymainTreePointQueue.poll();
                TreeNode currentSubTreeNode = temporarySubTreePointQueue.poll();
                if (currentMainTreeNode.value != currentSubTreeNode.value) {
                    return false;
                }
                if (currentMainTreeNode.leftTreeNodePoint != null) {
                    temporarymainTreePointQueue.add(currentMainTreeNode.leftTreeNodePoint);
                }
                if (currentSubTreeNode.leftTreeNodePoint != null) {
                    temporarySubTreePointQueue.add(currentSubTreeNode.leftTreeNodePoint);
                }
                if (currentMainTreeNode.rightTreeNodePoint != null) {
                    temporarymainTreePointQueue.add(currentMainTreeNode.rightTreeNodePoint);
                }
                if (currentSubTreeNode.rightTreeNodePoint != null) {
                    temporarySubTreePointQueue.add(currentSubTreeNode.rightTreeNodePoint);
                }
                if (temporarymainTreePointQueue.size() < temporarySubTreePointQueue.size()) {
                    return false;
                }

            }
        }
        return true;
    }

}