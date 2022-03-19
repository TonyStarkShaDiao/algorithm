package com.src.algorithm.datastructure.tree.prod.binarytree;

import javax.annotation.Resource;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 树路径总和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/07
 */
public class TreePathTotalSum {
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

   public Boolean mySelf_DepthFirstSearchHasTreePathTotalSum(TreeNode treeNodeRoot, int treeNodePathSum) {
        if (treeNodeRoot == null) {
            return false;
        }
        Stack<TreeNode> temporaryTreeNodeStack = new Stack<>();
        temporaryTreeNodeStack.add(treeNodeRoot);
        while (!temporaryTreeNodeStack.isEmpty()) {
            TreeNode currentTreeNode = temporaryTreeNodeStack.pop();
            if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null && currentTreeNode.value == treeNodePathSum) {
                return true;
            }
            if (currentTreeNode.leftTreeNode != null) {
                currentTreeNode.leftTreeNode.value = currentTreeNode.value + currentTreeNode.leftTreeNode.value;
                temporaryTreeNodeStack.add(currentTreeNode.leftTreeNode);
            }
            if (currentTreeNode.rightTreeNode != null) {
                currentTreeNode.rightTreeNode.value = currentTreeNode.value + currentTreeNode.rightTreeNode.value;
                temporaryTreeNodeStack.add(currentTreeNode.rightTreeNode);
            }
        }
        return false;
    }

   public Boolean mySelf_BreadthFirstSearchHasTreePathTotalSum(TreeNode treeNodeRoot, int treeNodePathSum) {
        if (treeNodeRoot == null) {
            return false;
        }
        Deque<TreeNode> temporaryTreeNodeDeque =new LinkedList<>();
        temporaryTreeNodeDeque.add(treeNodeRoot);
        while (!temporaryTreeNodeDeque.isEmpty()) {
            TreeNode current = temporaryTreeNodeDeque.pop();
            if (current.leftTreeNode==null&&current.rightTreeNode==null&&current.value==treeNodePathSum){
                return true;
            }
            if (current.leftTreeNode!=null){
                current.leftTreeNode.value= current.value+ current.leftTreeNode.value;
                temporaryTreeNodeDeque.push(current.leftTreeNode);
            }
            if (current.rightTreeNode!=null){
                current.rightTreeNode.value= current.value+ current.rightTreeNode.value;
                temporaryTreeNodeDeque.push(current.rightTreeNode);
            }
        }
        return false;
    }
  public   Boolean mySelf_RecursiveHasTreePathTotalSum(TreeNode treeNodeRoot, int treeNodePathSum) {
        if (treeNodeRoot == null) {
            return false;
        }
        if (treeNodeRoot.leftTreeNode==null&&treeNodeRoot.rightTreeNode==null){
            return treeNodePathSum==treeNodeRoot.value;
        }
        return mySelf_RecursiveHasTreePathTotalSum(treeNodeRoot.leftTreeNode,treeNodePathSum- treeNodeRoot.value)
                ||mySelf_RecursiveHasTreePathTotalSum(treeNodeRoot.rightTreeNode,treeNodePathSum-treeNodeRoot.value);
    }
}
