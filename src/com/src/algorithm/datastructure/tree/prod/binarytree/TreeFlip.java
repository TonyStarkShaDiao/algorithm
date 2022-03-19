package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

/**
 *翻转二叉树
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/06
 */

public class TreeFlip {
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
     * 我自己的广度优先遍历算法
     *
     * 重点在于队列
     * @param treeNode 树节点
     * @return {@link TreeNode}
     */
    public TreeNode mySelf_BreadthFirstTraversalTreeFlip(TreeNode treeNode){
        if (treeNode==null){
            return treeNode;
        }
        Deque<TreeNode> treeNodeDeque =new ArrayDeque<>();
        treeNodeDeque.add(treeNode);
        while (!treeNodeDeque.isEmpty()) {
            TreeNode currentTreeNode = treeNodeDeque.pop();
            TreeNode leftTreeNode = currentTreeNode.leftTreeNode;
            currentTreeNode.leftTreeNode=currentTreeNode.rightTreeNode;
            currentTreeNode.rightTreeNode=leftTreeNode;
            if (currentTreeNode.leftTreeNode!=null) {
                treeNodeDeque.add(currentTreeNode.leftTreeNode);
            }
            if (currentTreeNode.rightTreeNode!=null) {
                treeNodeDeque.add(currentTreeNode.rightTreeNode);
            }
        }
        return treeNode;
    }



    /**
     * 我自己递归树翻转
     *
     * @param treeNode 树节点
     * @return {@link TreeNode}
     */
    public TreeNode mySelf_RecursiveTreeFlip(TreeNode treeNode) {
        if (treeNode==null) {
            return null;
        }
        TreeNode CurrentLeftTreeNode = treeNode.leftTreeNode;
        treeNode.leftTreeNode=treeNode.rightTreeNode;
        treeNode.rightTreeNode=CurrentLeftTreeNode;
        mySelf_RecursiveTreeFlip(treeNode.leftTreeNode);
        mySelf_RecursiveTreeFlip(treeNode.rightTreeNode);
        return treeNode;
    }

    /**
     * 自己广度优先二叉树转换为数组
     *
     * @param treeNodeRoot 树节点根
     * @return {@link List}<{@link Integer}>
     */
    public Integer[] myself_BreadthFirstBinaryTreeConvertArrays(TreeNode treeNodeRoot){
        if (treeNodeRoot==null){
            return null;
        }
        Deque<TreeNode> treeNodeDeque =new ArrayDeque<>();
        treeNodeDeque.add(treeNodeRoot);
        List<Integer> treeNodeElementCollect =new ArrayList<>();
        while (!treeNodeDeque.isEmpty()) {
                TreeNode currentTreeNode = treeNodeDeque.pop();
                treeNodeElementCollect.add(currentTreeNode.value);
                if (currentTreeNode.leftTreeNode!=null) {
                    treeNodeDeque.add(currentTreeNode.leftTreeNode);
                }
                if (currentTreeNode.rightTreeNode!=null) {
                    treeNodeDeque.add(currentTreeNode.rightTreeNode);
                }
        }
        Integer[] integers = treeNodeElementCollect.toArray(new Integer[treeNodeDeque.size()]);
        return integers ;
    }
}
