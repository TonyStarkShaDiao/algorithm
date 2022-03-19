package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树前序遍历
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/22
 */
public class TreeFormerSequenceTraversal {

    //Definition for a binary tree node.
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

//    public List<Integer> myself_StackTreeFromTraversal(TreeNode rootNode) {
//        if (rootNode==null) {
//            return new ArrayList<>();
//        }
//        Stack<TreeNode> temporaryTreeNodeStack =new Stack<>();
//        List<Integer> treeNodeElementCollect =new ArrayList<>();
//        temporaryTreeNodeStack.push(rootNode);
//        while (!temporaryTreeNodeStack.isEmpty()) {
//            TreeNode currentTreNode = temporaryTreeNodeStack.pop();
//            treeNodeElementCollect.add(currentTreNode.value);
//            if (currentTreNode.rightTreeNode!=null){
//                temporaryTreeNodeStack.push(currentTreNode.rightTreeNode);
//            }
//            if (currentTreNode.leftTreeNode!=null) {
//                temporaryTreeNodeStack.push(currentTreNode.leftTreeNode);
//            }
//        }
//        return treeNodeElementCollect;
//    }

    public List<Integer> myself_StackTreeFromTraversal(TreeNode rootNode) {
        if (rootNode==null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> temporaryTreeNodeStack =new Stack<>();
        List<Integer> treeNodeElementCollect =new ArrayList<>();
        while (!temporaryTreeNodeStack.isEmpty()||rootNode!=null) {
            while (rootNode != null) {
                treeNodeElementCollect.add(rootNode.value);
                temporaryTreeNodeStack.push(rootNode);
                rootNode=rootNode.leftTreeNode;
            }
            TreeNode currentTreeNode = temporaryTreeNodeStack.pop();
            rootNode=currentTreeNode.rightTreeNode;

        }
        return treeNodeElementCollect;
    }


    public List<Integer> myself_RecursiveTreeSubsequentTraversal(TreeNode rootNode) {
       List<Integer> list =new ArrayList<>();
        if (rootNode == null) {
            return list;
        }
        recursiveTreeNode(rootNode,list);
        return list;
    }

    private void recursiveTreeNode(TreeNode rootNode, List<Integer> treeNodeValueResults) {
        if (rootNode==null){
            return;
        }
        treeNodeValueResults.add(rootNode.value);
        recursiveTreeNode(rootNode.leftTreeNode,treeNodeValueResults);
        recursiveTreeNode(rootNode.rightTreeNode,treeNodeValueResults);
    }
}
