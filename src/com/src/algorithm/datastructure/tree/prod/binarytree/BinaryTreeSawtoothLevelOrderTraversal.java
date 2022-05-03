package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

/**
 * 二叉树锯齿级层序遍历
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/03
 */
public class BinaryTreeSawtoothLevelOrderTraversal {
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

    public List<List<Integer>> mySelf_BinaryTreeSawtoothLLLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> treeLevelElementCollect = new LinkedList<List<Integer>>();
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        Boolean isOddNumber = true;
        while (!treeNodeQueue.isEmpty()) {
            Deque<Integer> levelElementCollect = new LinkedList<>();
            int level = treeNodeQueue.size();
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = treeNodeQueue.poll();
                if (isOddNumber) {
                    levelElementCollect.offerLast(currentTreeNode.value);
                } else {
                    levelElementCollect.offerFirst(currentTreeNode.value);
                }

                if (currentTreeNode.leftTreeNode != null) {
                    treeNodeQueue.offer(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    treeNodeQueue.offer(currentTreeNode.rightTreeNode);
                }
            }
            isOddNumber = !isOddNumber;
            treeLevelElementCollect.add(new LinkedList<>(levelElementCollect));
        }
        return treeLevelElementCollect;
    }
}
