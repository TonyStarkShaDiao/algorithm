package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Stack;

/**
 * 在树左下角查找值
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/22
 */
public class FindValueInLowerLeftCornerOfTree {

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

    public int mySelf_BfsFindValueInLowerLeftCornerOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftTreeNodePointValue = 0;
        int maximumDepth = 0;
        Stack<TreeNode> temporaryMainTreePointStack = new Stack<>();
        while (!temporaryMainTreePointStack.isEmpty() || root != null) {
            int currentDepth = 0;
            while (root != null) {
                temporaryMainTreePointStack.push(root);
                root = root.leftTreeNodePoint;
                if (root == null) {
                    break;
                }
                currentDepth++;
                if (currentDepth > maximumDepth) {
                    maximumDepth = currentDepth;
                    maxLeftTreeNodePointValue = root.value;
                }
                if (root.rightTreeNodePoint.leftTreeNodePoint == null) {
                    maximumDepth = currentDepth;
                    maxLeftTreeNodePointValue = root.rightTreeNodePoint.value;
                }

            }

            TreeNode currentMainTreeNode = temporaryMainTreePointStack.pop();
            root = currentMainTreeNode.rightTreeNodePoint;
        }
        return maxLeftTreeNodePointValue;
    }
}
