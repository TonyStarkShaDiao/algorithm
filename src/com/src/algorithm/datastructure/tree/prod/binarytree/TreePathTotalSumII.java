package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

public class TreePathTotalSumII {
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

    Map<TreeNode, TreeNode> currentTreeNodePreviousTreeNodeMap = new HashMap<>();
    List<List<Integer>> pathResultCollect = new ArrayList<>();

    public List<List<Integer>> mySelf_HashTreePathTotalSumII(TreeNode root, int pathSum) {
        if (root == null) {
            return pathResultCollect;
        }
        Queue<TreeNode> temporaryQueue = new LinkedList<>();
        Queue<Integer> currentPathSum = new LinkedList<>();
        temporaryQueue.add(root);
        currentPathSum.add(0);
        while (!temporaryQueue.isEmpty()) {
            TreeNode currentTreeNode = temporaryQueue.poll();
            int currentPathSumValue = currentTreeNode.value + currentPathSum.poll();
            if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
                if (currentPathSumValue == pathSum) {
                    Deque<Integer> currentPath = new LinkedList<>();
                    while (currentTreeNode != null) {
                        currentPath.addFirst(currentTreeNode.value);
                        currentTreeNode = currentTreeNodePreviousTreeNodeMap.get(currentTreeNode);
                    }
                    pathResultCollect.add(new ArrayList<>(currentPath));
                }
            } else {
                if (currentTreeNode.leftTreeNode != null) {
                    currentTreeNodePreviousTreeNodeMap.put(currentTreeNode.leftTreeNode, currentTreeNode);
                    temporaryQueue.offer(currentTreeNode.leftTreeNode);
                    currentPathSum.offer(currentPathSumValue);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    currentTreeNodePreviousTreeNodeMap.put(currentTreeNode.rightTreeNode, currentTreeNode);
                    temporaryQueue.offer(currentTreeNode.rightTreeNode);
                    currentPathSum.offer(currentPathSumValue);
                }
            }

        }
        return pathResultCollect;
    }
}
