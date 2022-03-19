package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 树后遍历树
 * 左右根
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/22
 */

public class TreeSubsequentTraversal {

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

    public List<Integer> myself_ReverseStackTreeTreeSubsequentTraversal(TreeNode rootNode) {
        List<Integer> treeNodeValueResults = new ArrayList<>();
        if (rootNode == null) {
            return treeNodeValueResults;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode currentRootNode = stack.pop();
            treeNodeValueResults.add(currentRootNode.value);
            if (currentRootNode.leftTreeNode != null) {
                stack.push(currentRootNode.leftTreeNode);
            }
            if (currentRootNode.rightTreeNode != null) {
                stack.push(currentRootNode.rightTreeNode);
            }
        }
        Collections.reverse(treeNodeValueResults);
        return treeNodeValueResults;
    }

    //    public List<Integer> myself_StackTreeFormerSequenceTraversal(TreeNode rootNode) {
//        List<Integer> treeNodeValueResults = new ArrayList<>();
//        if (rootNode == null) {
//            return treeNodeValueResults;
//        }
//        Stack<TreeNode> treeNodeStack = new Stack<>();
//        TreeNode usedTreeNode = null;
//        while (!treeNodeStack.isEmpty() || rootNode != null) {
//            while (rootNode != null) {
//                System.out.println(rootNode.value);
//                treeNodeStack.push(rootNode);
//                rootNode = rootNode.leftTreeNode;
//            }
//            rootNode = treeNodeStack.pop();
//            if (rootNode.rightTreeNode == null || rootNode.rightTreeNode == usedTreeNode) {
//                treeNodeValueResults.add(rootNode.value);
//                usedTreeNode = rootNode;
//                rootNode = null;
//            } else {
//                treeNodeStack.push(rootNode);
//                rootNode = rootNode.rightTreeNode;
//            }
//        }
//        return treeNodeValueResults;
//    }
//    public List<Integer> myself_StackTreeFormerSequenceTraversal(TreeNode rootNode) {
//        List<Integer> treeNodeValueResults = new ArrayList<>();
//        if (rootNode == null) {
//            return treeNodeValueResults;
//        }
//        Stack<TreeNode> treeNodeStack = new Stack<>();
//        TreeNode usedTreeNode = null;
//        while (!treeNodeStack.isEmpty() || rootNode != null) {
//            while (rootNode != null) {
//                treeNodeStack.push(rootNode);
//                rootNode = rootNode.leftTreeNode;
//            }
//            rootNode = treeNodeStack.pop();
//            if (rootNode.rightTreeNode == null || rootNode.rightTreeNode == usedTreeNode) {
//                treeNodeValueResults.add(rootNode.value);
//                usedTreeNode = rootNode;
//                rootNode = null;
//            } else {
//                treeNodeStack.push(rootNode);
//                rootNode = rootNode.rightTreeNode;
//            }
//
//        }
//        return treeNodeValueResults;
//    }
//    public List<Integer> myself_StackTreeTreeSubsequentTraversal(TreeNode rootNode) {
//        if (rootNode == null) {
//            return new ArrayList<>();
//        }
//        TreeNode usedTreeNode = null;
//        Stack<TreeNode> temporaryTreeNodeStack = new Stack<>();
//        List<Integer> treeNodeElementCollect = new ArrayList<>();
//        while (rootNode != null || !temporaryTreeNodeStack.isEmpty()) {
//            while (rootNode != null) {
//                temporaryTreeNodeStack.push(rootNode);
//                rootNode = rootNode.leftTreeNode;
//            }
//            rootNode = temporaryTreeNodeStack.pop();
//            if (rootNode.rightTreeNode == null || rootNode.rightTreeNode == usedTreeNode) {
//                treeNodeElementCollect.add(rootNode.value);
//                usedTreeNode = rootNode;
//                rootNode = null;
//            } else {
//                temporaryTreeNodeStack.push(rootNode);
//                rootNode = rootNode.rightTreeNode;
//            }
//        }
//        return treeNodeElementCollect;
//    }

    public List<Integer> myself_StackTreeTreeSubsequentTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return new ArrayList<>();
        }
        TreeNode usedTreeNode = null;
        Stack<TreeNode> temporaryTreeNodeStack = new Stack<>();
        List<Integer> treeNodeElementCollect = new ArrayList<>();
        while (!temporaryTreeNodeStack.isEmpty() || rootNode != null) {
            while (rootNode != null) {
                temporaryTreeNodeStack.push(rootNode);
                rootNode=rootNode.leftTreeNode;
            }
            TreeNode currentTreeNode = temporaryTreeNodeStack.pop();
            if (currentTreeNode.rightTreeNode==null||currentTreeNode.rightTreeNode==usedTreeNode){
                treeNodeElementCollect.add(currentTreeNode.value);
                usedTreeNode=currentTreeNode;
                rootNode=null;
            }else {
                temporaryTreeNodeStack.push(currentTreeNode);
                rootNode=currentTreeNode.rightTreeNode;
            }
        }
        return treeNodeElementCollect;
    }

    public List<Integer> myself_RecursiveTreeSubsequentTraversal(TreeNode rootNode) {
        List<Integer> treeNodeValueResults = new ArrayList<>();
        recursiveTreeNode(rootNode, treeNodeValueResults);
        return treeNodeValueResults;
    }

    private void recursiveTreeNode(TreeNode rootNode, List<Integer> treeNodeValueResults) {
        if (rootNode == null) {
            return;
        }
        recursiveTreeNode(rootNode.leftTreeNode, treeNodeValueResults);
        recursiveTreeNode(rootNode.rightTreeNode, treeNodeValueResults);
        treeNodeValueResults.add(rootNode.value);
    }
}
