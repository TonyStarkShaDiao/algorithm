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
