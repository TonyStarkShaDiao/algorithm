package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

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

    public boolean mySelf_levelTraversalIsSameTree(TreeNode FirstOneTreeNode, TreeNode SecondOneTreeNode) {
        Queue<TreeNode> temporaryAllTreeNodePointQueue = new LinkedList<>();
        temporaryAllTreeNodePointQueue.add(FirstOneTreeNode);
        temporaryAllTreeNodePointQueue.add(SecondOneTreeNode);
        while (!temporaryAllTreeNodePointQueue.isEmpty()) {
            TreeNode currentFirstOneTreeNodePoint = temporaryAllTreeNodePointQueue.poll();
            TreeNode currentSecondOneTreeNodePoint = temporaryAllTreeNodePointQueue.poll();
            if (currentFirstOneTreeNodePoint == null && currentSecondOneTreeNodePoint == null) {
                continue;
            }
            if (currentFirstOneTreeNodePoint == null || currentSecondOneTreeNodePoint == null || currentFirstOneTreeNodePoint.value != currentSecondOneTreeNodePoint.value) {
                return false;
            }
            temporaryAllTreeNodePointQueue.add(currentFirstOneTreeNodePoint.leftTreeNode);
            temporaryAllTreeNodePointQueue.add(currentSecondOneTreeNodePoint.leftTreeNode);
            temporaryAllTreeNodePointQueue.add(currentFirstOneTreeNodePoint.rightTreeNode);
            temporaryAllTreeNodePointQueue.add(currentSecondOneTreeNodePoint.rightTreeNode);
        }
        return true;
    }
}
