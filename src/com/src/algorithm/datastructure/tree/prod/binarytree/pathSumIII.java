package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和 III
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/26
 */
public class pathSumIII {
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

    public int mySelf_preorderTraversal(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> temporaryTreeNodePointQueue = new LinkedList<>();
        TreeNode currentTreeNode = root;
        temporaryTreeNodePointQueue.add(currentTreeNode);
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            TreeNode currentPollTreeNodePoint = temporaryTreeNodePointQueue.poll();
            count += this.TreeNodePathSum(currentPollTreeNodePoint, target);
            if (currentPollTreeNodePoint.leftTreeNode != null) {
                temporaryTreeNodePointQueue.add(currentPollTreeNodePoint.leftTreeNode);
            }
            if (currentPollTreeNodePoint.rightTreeNode != null) {
                temporaryTreeNodePointQueue.add(currentPollTreeNodePoint.rightTreeNode);
            }
        }
        return count;
    }

    private int TreeNodePathSum(TreeNode treeNodeRoot, int target) {
        TreeNode currentTreeNode = treeNodeRoot;
        int count = 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> treeNodeElementSumQueue = new LinkedList<>();
        treeNodeQueue.add(currentTreeNode);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode currentPollTreeNodePoint = treeNodeQueue.poll();
            int currentPollTreeNodeElementSum = treeNodeElementSumQueue.poll();
            if (currentPollTreeNodePoint.leftTreeNode == null && currentPollTreeNodePoint.rightTreeNode == null) {
                if (currentPollTreeNodeElementSum + currentPollTreeNodePoint.value == target) {
                    count++;
                } else {
                    continue;
                }
            }
            if (currentPollTreeNodePoint.leftTreeNode != null) {
                treeNodeQueue.add(currentPollTreeNodePoint.leftTreeNode);
                treeNodeElementSumQueue.add(currentPollTreeNodeElementSum + currentPollTreeNodePoint.value);
            }
            if (currentPollTreeNodePoint.rightTreeNode != null) {
                treeNodeQueue.add(currentPollTreeNodePoint.rightTreeNode);
                treeNodeElementSumQueue.add(currentPollTreeNodeElementSum + currentPollTreeNodePoint.value);
            }
        }
        return count;
    }
}

