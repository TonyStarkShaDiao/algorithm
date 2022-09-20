package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

/**
 * 二叉树直径
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/26
 */
public class DiameterOfBinaryTree {
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

    /**
     * 我自前序遍历查找二叉树直径
     *
     * @param treeNodeRoot 树节点根
     * @return int
     */
    public int mySelf_preorderTraversalFindDiameterOfBinaryTree(TreeNode treeNodeRoot, int target) {
        if (treeNodeRoot == null) {
            return 0;
        }
        List<TreeNode> treeNodePointCollect = new ArrayList<>();
        return this.preorderTraversalFindDiameterOfBinaryTree(treeNodeRoot, treeNodePointCollect, target);
    }

    private int preorderTraversalFindDiameterOfBinaryTree(TreeNode treeNodeRoot, List<TreeNode> treeNodePathPointCollect, int target) {
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<>();
        temporaryTreeNodePointStack.push(treeNodeRoot);
        int currentRootTreeNodeTotalNumber = 0;

        while (!temporaryTreeNodePointStack.isEmpty()) {
            TreeNode currentPopTreeNodePoint = temporaryTreeNodePointStack.pop();
            if (currentPopTreeNodePoint.rightTreeNode != null) {
                temporaryTreeNodePointStack.push(currentPopTreeNodePoint.rightTreeNode);
            }
            if (currentPopTreeNodePoint.leftTreeNode != null) {
                temporaryTreeNodePointStack.push(currentPopTreeNodePoint.leftTreeNode);
            }
            if (treeNodePathPointCollect.size() >= 1) {
                while (true) {
                    if (treeNodePathPointCollect.get(treeNodePathPointCollect.size() - 1).leftTreeNode == currentPopTreeNodePoint ||
                            treeNodePathPointCollect.get(treeNodePathPointCollect.size() - 1).rightTreeNode == currentPopTreeNodePoint) {
                        break;
                    } else {
                        treeNodePathPointCollect.remove(treeNodePathPointCollect.size() - 1);
                    }
                }
            }
            treeNodePathPointCollect.add(currentPopTreeNodePoint);
            int oneTreeNodeRootPathSum = 0;
            for (int treeNodePointCollectIndex = treeNodePathPointCollect.size() - 1; treeNodePointCollectIndex >= 0; treeNodePointCollectIndex--) {
                oneTreeNodeRootPathSum += treeNodePathPointCollect.get(treeNodePointCollectIndex).value;
                if (oneTreeNodeRootPathSum == target) {
                    currentRootTreeNodeTotalNumber++;
                }
            }
        }
        return currentRootTreeNodeTotalNumber;
    }

    /**
     * 我自己的后期订单横向
     * 二叉树自后序遍历直径
     *
     * @param treeNodeRoot 树节点根
     * @return int
     */
    @Deprecated
    public int myself_PostorderTraversalFindDiameter(TreeNode treeNodeRoot) {
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<>();
        TreeNode currentTreeNode = treeNodeRoot;
        List<Integer> list = new ArrayList<>();
        TreeNode previousTreeNode = null;
        int maxDiameter = 0;
        while (!temporaryTreeNodePointStack.isEmpty() || currentTreeNode != null) {
            while (currentTreeNode != null) {
                temporaryTreeNodePointStack.push(currentTreeNode);
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
            TreeNode currentTreeNodePoint = temporaryTreeNodePointStack.pop();
            if (currentTreeNodePoint.rightTreeNode == null || currentTreeNodePoint.rightTreeNode == previousTreeNode) {
                list.add(currentTreeNodePoint.value);
                int leftDepth = this.getDepth(currentTreeNodePoint.leftTreeNode);
                int rightDepth = this.getDepth(currentTreeNodePoint.rightTreeNode);
                maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
                previousTreeNode = currentTreeNodePoint;
            } else {
                temporaryTreeNodePointStack.push(currentTreeNodePoint);
                currentTreeNode = currentTreeNodePoint.rightTreeNode;
            }
        }
        return maxDiameter;
    }

    @Deprecated
    private int getDepth(TreeNode treeNodeRoot) {
        if (treeNodeRoot == null) {
            return 0;
        }
        Queue<TreeNode> temporaryTreeNodePointQueue = new ArrayDeque<>();
        temporaryTreeNodePointQueue.add(treeNodeRoot);
        int depth = 0;
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            int size = temporaryTreeNodePointQueue.size();
            depth++;
            while (size-- > 0) {
                TreeNode currentPollTreeNodePoint = temporaryTreeNodePointQueue.poll();
                if (currentPollTreeNodePoint.leftTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentPollTreeNodePoint.leftTreeNode);
                }
                if (currentPollTreeNodePoint.rightTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentPollTreeNodePoint.rightTreeNode);
                }
            }

        }
        return depth;
    }

}
