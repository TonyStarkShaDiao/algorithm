package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 另一棵树的子树
 * aSubtreeOfAnotherTree
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/25
 */
public class SubtreeOfAnotherTree {
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

    public boolean isSubtree(TreeNode targetTreeNodeRoot, TreeNode needCheckSubTree) {
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<>();
        TreeNode temporaryTreeNodePoint = targetTreeNodeRoot;
        while (temporaryTreeNodePoint != null || !temporaryTreeNodePointStack.isEmpty()) {
            while (temporaryTreeNodePoint != null) {
                temporaryTreeNodePointStack.push(temporaryTreeNodePoint);
                temporaryTreeNodePoint = temporaryTreeNodePoint.leftTreeNode;
            }
            TreeNode currentTreeNodePoint = temporaryTreeNodePointStack.pop();
            if (currentTreeNodePoint.value == needCheckSubTree.value) {
                if (this.isSubTree(currentTreeNodePoint, needCheckSubTree)) {
                    return true;
                }
            }
            temporaryTreeNodePoint = currentTreeNodePoint.rightTreeNode;
        }
        return false;
    }

    private boolean isSubTree(TreeNode firstOneTreeNode, TreeNode secondOneTreeNode) {
        Queue<TreeNode> temporaryTreeNodePointQueue = new LinkedList<>();
        temporaryTreeNodePointQueue.offer(firstOneTreeNode);
        temporaryTreeNodePointQueue.offer(secondOneTreeNode);
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            TreeNode currentFirstOneTreeNodePoint = temporaryTreeNodePointQueue.poll();
            TreeNode currentSecondOneTreeNodePoint = temporaryTreeNodePointQueue.poll();
            if (currentFirstOneTreeNodePoint == null && currentSecondOneTreeNodePoint == null) {
                continue;
            }
            if (currentFirstOneTreeNodePoint == null || currentSecondOneTreeNodePoint == null || currentFirstOneTreeNodePoint.value != currentSecondOneTreeNodePoint.value) {
                return false;
            }
            temporaryTreeNodePointQueue.offer(currentFirstOneTreeNodePoint.leftTreeNode);
            temporaryTreeNodePointQueue.offer(currentSecondOneTreeNodePoint.leftTreeNode);
            temporaryTreeNodePointQueue.offer(currentFirstOneTreeNodePoint.rightTreeNode);
            temporaryTreeNodePointQueue.offer(currentSecondOneTreeNodePoint.rightTreeNode);
        }
        return true;
    }
}
