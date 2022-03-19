package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树在最近共同祖先
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/18
 */
public class BinarySearchTreeInRecentCommonAncestor {


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


    /**
     * 我自己最近共同祖先一次遍历二叉搜索树
     *
     * @param binarySearchTreeNodeRoot     二叉搜索树根节点
     * @param firstOneBinarySearchTreeNode 第一个二叉搜索树节点
     * @param secondBinarySearchTreeNode   第二个二叉搜索树节点
     * @return {@code BinarySearchTreeNode}
     */
    public BinarySearchTreeNode mySelf_onceTraverseBinarySearchTreeInRecentCommonAncestor(BinarySearchTreeNode binarySearchTreeNodeRoot, BinarySearchTreeNode firstOneBinarySearchTreeNode, BinarySearchTreeNode secondBinarySearchTreeNode) {
        BinarySearchTreeNode currentBinarySearchTreeNode =binarySearchTreeNodeRoot;
        while (true){
            if (firstOneBinarySearchTreeNode.value>currentBinarySearchTreeNode.value&&secondBinarySearchTreeNode.value>currentBinarySearchTreeNode.value){
                currentBinarySearchTreeNode=currentBinarySearchTreeNode.rightTreeNode;
            }else if (firstOneBinarySearchTreeNode.value<currentBinarySearchTreeNode.value&&secondBinarySearchTreeNode.value<currentBinarySearchTreeNode.value){
                currentBinarySearchTreeNode=currentBinarySearchTreeNode.leftTreeNode;
            }else {
                break;
            }
        }
        return currentBinarySearchTreeNode;
    }

    public BinarySearchTreeNode mySelf_TwoTraverseBinarySearchTreeInRecentCommonAncestor(BinarySearchTreeNode binarySearchTreeNodeRoot, BinarySearchTreeNode firstOneBinarySearchTreeNode, BinarySearchTreeNode secondBinarySearchTreeNode) {
        List<BinarySearchTreeNode> firstOneBinarySearchTreeNodePaths = meetsRequirementsForAllPaths(binarySearchTreeNodeRoot, firstOneBinarySearchTreeNode);
        List<BinarySearchTreeNode> secondBinarySearchTreeNodePaths = meetsRequirementsForAllPaths(binarySearchTreeNodeRoot, secondBinarySearchTreeNode);
        BinarySearchTreeNode resultBinarySearchTreeNode = null;
        for (int binarySearchTreeIndex = 0; binarySearchTreeIndex < firstOneBinarySearchTreeNodePaths.size() && binarySearchTreeIndex < secondBinarySearchTreeNodePaths.size(); binarySearchTreeIndex++) {
            if (firstOneBinarySearchTreeNodePaths.get(binarySearchTreeIndex) == secondBinarySearchTreeNodePaths.get(binarySearchTreeIndex)) {
                resultBinarySearchTreeNode = firstOneBinarySearchTreeNodePaths.get(binarySearchTreeIndex);
            } else {
                break;
            }
        }
        return resultBinarySearchTreeNode;
    }

    public List<BinarySearchTreeNode> meetsRequirementsForAllPaths(BinarySearchTreeNode binarySearchTreeNodeRoot, BinarySearchTreeNode targetOneBinarySearchTreeNode) {
        BinarySearchTreeNode currentBinarySearchTreeNode = binarySearchTreeNodeRoot;
        List<BinarySearchTreeNode> BinarySearchTreeNodePaths = new ArrayList<>();
        while (currentBinarySearchTreeNode != targetOneBinarySearchTreeNode) {
            BinarySearchTreeNodePaths.add(currentBinarySearchTreeNode);
            if (targetOneBinarySearchTreeNode.value < currentBinarySearchTreeNode.value) {
                currentBinarySearchTreeNode = currentBinarySearchTreeNode.leftTreeNode;
            } else {
                currentBinarySearchTreeNode = currentBinarySearchTreeNode.rightTreeNode;
            }
        }
        BinarySearchTreeNodePaths.add(currentBinarySearchTreeNode);
        return BinarySearchTreeNodePaths;
    }

    public Boolean checkBinarySearchTreeNode(BinarySearchTreeNode binarySearchTreeNodeRoot) {
        Stack<BinarySearchTreeNode> temporaryBinarySearchTreeStack =new Stack<>();
          long  currentMinValue=Long.MIN_VALUE;
        while (!temporaryBinarySearchTreeStack.isEmpty() || binarySearchTreeNodeRoot != null) {
            while (binarySearchTreeNodeRoot != null) {
                temporaryBinarySearchTreeStack.push(binarySearchTreeNodeRoot);
                binarySearchTreeNodeRoot=binarySearchTreeNodeRoot.leftTreeNode;
            }
            binarySearchTreeNodeRoot = temporaryBinarySearchTreeStack.pop();
            if (binarySearchTreeNodeRoot.value<=currentMinValue){
                return false;
            }
            currentMinValue= binarySearchTreeNodeRoot.value;
            binarySearchTreeNodeRoot=binarySearchTreeNodeRoot.rightTreeNode;
        }
        return true;
    }
}
