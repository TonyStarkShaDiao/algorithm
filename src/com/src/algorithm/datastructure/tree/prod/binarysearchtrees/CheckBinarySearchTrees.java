package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.Stack;

public class CheckBinarySearchTrees {
    public static class BinarySearchTreeNode {
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int value;
        public BinarySearchTreeNode leftTreeNode;
        public BinarySearchTreeNode rightTreeNode;

        public BinarySearchTreeNode() {
        }

        public BinarySearchTreeNode(int val) {
            this.value = val;
        }

        public BinarySearchTreeNode(int val, BinarySearchTreeNode left, BinarySearchTreeNode right) {
            this.value = val;
            this.leftTreeNode = left;
            this.rightTreeNode = right;
        }
    }

    /**
     * 我自己中序遍历二叉搜索树
     *
     * @param binarySearchTreeNodeRoot 二叉搜索树根节点
     * @return {@link Boolean}
     */
    public Boolean mySelf_MiddleSequenceTraverseCheckBinarySearchTrees(BinarySearchTreeNode binarySearchTreeNodeRoot) {
        Stack<BinarySearchTreeNode> TemporaryBinarySearchTreeNodeStack = new Stack<>();
        long currentMinValue = Long.MIN_VALUE;
        while (!TemporaryBinarySearchTreeNodeStack.isEmpty() || binarySearchTreeNodeRoot != null) {
            while (binarySearchTreeNodeRoot != null) {
                TemporaryBinarySearchTreeNodeStack.add(binarySearchTreeNodeRoot);
                binarySearchTreeNodeRoot = binarySearchTreeNodeRoot.leftTreeNode;
            }
            BinarySearchTreeNode currentBinarySearchTreeNode = TemporaryBinarySearchTreeNodeStack.pop();
            if (currentBinarySearchTreeNode.value <= currentMinValue) {
                return false;
            }
            currentMinValue = currentBinarySearchTreeNode.value;
            binarySearchTreeNodeRoot = currentBinarySearchTreeNode.rightTreeNode;
        }
        return true;
    }

    public Boolean mySelf_RecursiveCheckBinarySearchTrees(BinarySearchTreeNode binarySearchTreeNodeRoot) {
        return RecursiveCheckBinarySearchTrees(binarySearchTreeNodeRoot, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    /**
     * 递归检查二叉搜索树
     *
     * @param binarySearchTreeNodeRoot 二叉搜索树根节点
     * @param currentMaximum           目前最大
     * @param currentMinimum           目前最低
     * @return boolean
     */
    public boolean RecursiveCheckBinarySearchTrees(BinarySearchTreeNode binarySearchTreeNodeRoot, long currentMaximum, long currentMinimum) {
        if (binarySearchTreeNodeRoot == null) {
            return true;
        }
        if (binarySearchTreeNodeRoot.value >= currentMaximum || binarySearchTreeNodeRoot.value <= currentMinimum) {
            return false;
        }
        return RecursiveCheckBinarySearchTrees(binarySearchTreeNodeRoot.leftTreeNode,  binarySearchTreeNodeRoot.value,currentMinimum)
                &&
               RecursiveCheckBinarySearchTrees(binarySearchTreeNodeRoot.rightTreeNode  ,currentMaximum,binarySearchTreeNodeRoot.value);
    }

    ;

    /**
     * 我自己递归深度优先搜索检查二叉搜索树
     *
     * @param binarySearchTreeNodeRoot 二叉搜索树根节点
     * @return {@link Boolean}
     */
    public Boolean mySelf_RecursiveDepthFirstSearchCheckBinarySearchTrees(BinarySearchTreeNode binarySearchTreeNodeRoot) {
        if (binarySearchTreeNodeRoot.leftTreeNode==null&&binarySearchTreeNodeRoot.leftTreeNode==null){
            return true;
        }
        int currentMinValue = Integer.MIN_VALUE;
        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode();
        binarySearchTreeNode.setValue(currentMinValue);
        return RecursiveDepthFirstSearchCheckBinarySearchTrees(binarySearchTreeNodeRoot, new BinarySearchTreeNode( currentMinValue));
    }

    private Boolean RecursiveDepthFirstSearchCheckBinarySearchTrees(BinarySearchTreeNode binarySearchTreeNodeRoot, BinarySearchTreeNode currentMinBinarySearchTreeNode) {
        if (binarySearchTreeNodeRoot == null) {
            return true;
        }
        if (!RecursiveDepthFirstSearchCheckBinarySearchTrees(binarySearchTreeNodeRoot.leftTreeNode, currentMinBinarySearchTreeNode)) {
            return false;
        }
        System.out.println("当前树节点的值"+binarySearchTreeNodeRoot.getValue());
        System.out.println("当前最小值"+currentMinBinarySearchTreeNode.getValue());
        if (binarySearchTreeNodeRoot.getValue() <= currentMinBinarySearchTreeNode.getValue()) {
            return false;
        }
        currentMinBinarySearchTreeNode.setValue(binarySearchTreeNodeRoot.getValue());
        return RecursiveDepthFirstSearchCheckBinarySearchTrees(binarySearchTreeNodeRoot.rightTreeNode, currentMinBinarySearchTreeNode);
    }
}
