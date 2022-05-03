package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树树层序遍历
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/02
 *
 */
public class TreeLevelTraversal {
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

    public List<List<Integer>> myself_QueueLevelTraversal(TreeNode treeNodeRoot) {
        if (treeNodeRoot == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> treeNodeLevelElementCollect = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.add(treeNodeRoot);
        while (!treeNodeDeque.isEmpty()) {
            int level = treeNodeDeque.size();
            List<Integer> treeNodeElementCollect = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode currentTreeNode = treeNodeDeque.poll();
                treeNodeElementCollect.add(currentTreeNode.value);
                if (currentTreeNode.leftTreeNode != null) {
                    treeNodeDeque.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode != null) {
                    treeNodeDeque.add(currentTreeNode.rightTreeNode);
                }

            }
            treeNodeLevelElementCollect.add(treeNodeElementCollect);
        }
        return treeNodeLevelElementCollect;
    }

    public List<List<Integer>> myself_RecursiveLevelTraversal(TreeNode treeNodeRoot) {
        if (treeNodeRoot == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> treeNodeLevelElementCollect = new ArrayList<>();
        ;
        int level = 0;
        recursiveLevelTraversal(treeNodeRoot, treeNodeLevelElementCollect, level);
        return treeNodeLevelElementCollect;
    }

    private void recursiveLevelTraversal(TreeNode treeNodeRoot, List<List<Integer>> treeNodeLevelElementCollect, int level) {
        if (treeNodeRoot == null) {
            return;
        }

        if (treeNodeLevelElementCollect.size() <= level++) {
            treeNodeLevelElementCollect.add(new ArrayList<>());
        }
        treeNodeLevelElementCollect.get(level - 1).add(treeNodeRoot.value);
        recursiveLevelTraversal(treeNodeRoot.leftTreeNode, treeNodeLevelElementCollect, level);
        recursiveLevelTraversal(treeNodeRoot.rightTreeNode, treeNodeLevelElementCollect, level);
    }
}


//    if (treeNodeRoot==null){
//            return;
//            }
//            level++;
//            if (lists.size()<level){
//        List<Integer> item = new ArrayList<Integer>();
//        lists.add(item);
//        }
//        lists.get(level-1).add(treeNodeRoot.value);
//        RecursiveLevelTraversal(lists,treeNodeRoot.leftTreeNode,level);
//        RecursiveLevelTraversal(lists,treeNodeRoot.rightTreeNode,level);