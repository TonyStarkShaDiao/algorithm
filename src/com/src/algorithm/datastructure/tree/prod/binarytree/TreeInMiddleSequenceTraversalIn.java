package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树中序遍历
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/28
 */
public class TreeInMiddleSequenceTraversalIn {
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

//    /**
//     * 我自己迭代中序遍历
//     * 左根右
//     *
//     * @param treeNodeRoot 树节点根
//     * @return {@link List}<{@link Integer}>
//     */
//    public List<Integer> mySelf_IterationInMiddleSequenceTraversalIn(TreeNode treeNodeRoot) {
//        if (treeNodeRoot==null) {
//            return  new ArrayList<>();
//        }
//        List<Integer> treeNodeElementCollect =new ArrayList<>();;
//        Stack<TreeNode> temporaryNodeTreeStack =new Stack<>();
//        while (!temporaryNodeTreeStack.isEmpty() || treeNodeRoot != null) {
//            while (treeNodeRoot != null) {
//                temporaryNodeTreeStack.push(treeNodeRoot);
//                treeNodeRoot=treeNodeRoot.leftTreeNode;
//            }
//            treeNodeRoot=  temporaryNodeTreeStack.pop();
//            treeNodeElementCollect.add(treeNodeRoot.value);
//            treeNodeRoot=treeNodeRoot.rightTreeNode;
//        }
//        return treeNodeElementCollect;
//    }
    public List<Integer> mySelf_IterationInMiddleSequenceTraversalIn(TreeNode treeNodeRoot) {
        if (treeNodeRoot==null) {
            return  new ArrayList<>();
        }
        List<Integer> treeNodeElementCollect =new ArrayList<>();;
        Stack<TreeNode> temporaryNodeTreeStack =new Stack<>();
        while (!temporaryNodeTreeStack.isEmpty() || treeNodeRoot != null) {
            while (treeNodeRoot != null) {
                temporaryNodeTreeStack.push(treeNodeRoot);
                treeNodeRoot=treeNodeRoot.leftTreeNode;
            }
            TreeNode currentTreeNode = temporaryNodeTreeStack.pop();
            treeNodeElementCollect.add(currentTreeNode.value);
            treeNodeRoot=currentTreeNode.rightTreeNode;
        }
        return treeNodeElementCollect;
    }

//    public List<Integer> mySelf_IterationInMiddleSequenceTraversalIn(TreeNode treeNodeRoot) {
//        if (treeNodeRoot == null) {
//            return new ArrayList<Integer>();
//        }
//        List<Integer> treeNodeElementCollection = new ArrayList<>();
//        TreeNode temporaryTreeNode = treeNodeRoot;
//        Stack<TreeNode> treeNodeStack = new Stack<>();
//        while (temporaryTreeNode != null || !treeNodeStack.isEmpty()) {
//            while (temporaryTreeNode != null) {
//                treeNodeStack.push(temporaryTreeNode);
//                temporaryTreeNode = temporaryTreeNode.leftTreeNode;
//            }
//            TreeNode currentTreeNode = treeNodeStack.pop();
//            treeNodeElementCollection.add(currentTreeNode.value);
//            temporaryTreeNode = currentTreeNode.rightTreeNode;
//        }
//        return treeNodeElementCollection;
//    }

    public List<Integer> mySelf_RecursiveInMiddleSequenceTraversalIn(TreeNode treeNodeRoot) {
       if (treeNodeRoot==null){
           return new ArrayList<Integer>();
       }
       List<Integer> treeNodeElementCollection =new ArrayList<>();
        RecursiveInMiddleSequenceTraversalIn(treeNodeRoot,treeNodeElementCollection);
        return treeNodeElementCollection;
    }

    private void RecursiveInMiddleSequenceTraversalIn(TreeNode treeNodeRoot, List<Integer> treeNodeElementCollection) {
    if (treeNodeRoot==null){
        return;
    }
        RecursiveInMiddleSequenceTraversalIn(treeNodeRoot.leftTreeNode,treeNodeElementCollection);
        treeNodeElementCollection.add(treeNodeRoot.value);
        RecursiveInMiddleSequenceTraversalIn(treeNodeRoot.rightTreeNode,treeNodeElementCollection);

    }

}
