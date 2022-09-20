package com.src.algorithm.datastructure.tree.prod.binarytree;


import java.util.*;

/**
 * 二叉树序列遍历Ⅱ
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/29
 */
public class SequenceTraversalOfBinaryTreeII {
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

    public List<List<Integer>> mySelf_bfsSequenceTraversalOfBinaryTreeII(TreeNode treeNodeRoot) {
        if (treeNodeRoot == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelElementResultCollect = new ArrayList<>();
        Queue<TreeNode> temporaryTreeNodePointQueue = new LinkedList<>();
        temporaryTreeNodePointQueue.add(treeNodeRoot);
        while (!temporaryTreeNodePointQueue.isEmpty()) {
            int currentLevel = temporaryTreeNodePointQueue.size();
            List<Integer> currentLevelElementResultCollect = new ArrayList<>();
            while (currentLevel-- > 0) {
                TreeNode currentTreeNode = temporaryTreeNodePointQueue.poll();
                currentLevelElementResultCollect.add(currentTreeNode.value);
                if (currentTreeNode.leftTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    temporaryTreeNodePointQueue.add(currentTreeNode.rightTreeNode);
                }
            }
            levelElementResultCollect.add(currentLevelElementResultCollect);
        }
        Collections.reverse(levelElementResultCollect);

        return levelElementResultCollect;
    }


}

