package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.*;

/**
 * 二叉搜索树搜索
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/09
 */
public class BinarySearchTreeSearch {
    public static class BinarySearchTreeNode {
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
    public BinarySearchTreeNode mySelf_TraverseBinarySearchTreeSearch(BinarySearchTreeNode binarySearchTreeNodeRoot, int matchValue){
        if (binarySearchTreeNodeRoot==null){
            return binarySearchTreeNodeRoot;
        }
        while (binarySearchTreeNodeRoot != null) {
            if (binarySearchTreeNodeRoot.value==matchValue) {
                return binarySearchTreeNodeRoot;
            }
            binarySearchTreeNodeRoot=binarySearchTreeNodeRoot.value<matchValue?binarySearchTreeNodeRoot.rightTreeNode:binarySearchTreeNodeRoot.leftTreeNode;
        }
        return null;
    }

    public BinarySearchTreeNode mySelf_RecursiveBinarySearchTreeSearch(BinarySearchTreeNode binarySearchTreeNodeRoot, int matchValue){
        if (binarySearchTreeNodeRoot==null){
            return binarySearchTreeNodeRoot;
        }
        if (binarySearchTreeNodeRoot.value==matchValue){
            return binarySearchTreeNodeRoot;
        }
        return matchValue>binarySearchTreeNodeRoot.value?mySelf_RecursiveBinarySearchTreeSearch(binarySearchTreeNodeRoot.rightTreeNode,matchValue)
                :mySelf_RecursiveBinarySearchTreeSearch(binarySearchTreeNodeRoot.leftTreeNode,matchValue);
    }
    public Integer[] TraverseBinarySearchTreeSearchConvertArrayBFS(BinarySearchTreeNode binarySearchTreeNodeRoot) {
        if (binarySearchTreeNodeRoot==null){
            return null;
        }
        Deque<BinarySearchTreeNode> temporaryBinarySearchTreeNodeDeque =new ArrayDeque<>();
        List<Integer> binarySearchTreeNodeElementList =new ArrayList<>();
        temporaryBinarySearchTreeNodeDeque.add(binarySearchTreeNodeRoot);
        while (!temporaryBinarySearchTreeNodeDeque.isEmpty()) {
            BinarySearchTreeNode currentBinarySearchTreeNode = temporaryBinarySearchTreeNodeDeque.pop();
            binarySearchTreeNodeElementList.add(currentBinarySearchTreeNode.value);
            if (currentBinarySearchTreeNode.leftTreeNode!=null){
                temporaryBinarySearchTreeNodeDeque.add(currentBinarySearchTreeNode.leftTreeNode);
            }
            if (currentBinarySearchTreeNode.rightTreeNode!=null){
                temporaryBinarySearchTreeNodeDeque.add(currentBinarySearchTreeNode.rightTreeNode);
            }
        }
        return binarySearchTreeNodeElementList.toArray(new Integer[binarySearchTreeNodeElementList.size()]);
    }
}
