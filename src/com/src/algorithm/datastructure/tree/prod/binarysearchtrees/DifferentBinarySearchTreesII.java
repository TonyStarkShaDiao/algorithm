package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同二叉搜索树 II
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/02
 */
public class DifferentBinarySearchTreesII {
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

    public List<BinarySearchTreeNode> mySelfToFlashBackDifferentBinarySearchTreesII(int cutOffNumber) {
        if (cutOffNumber == 0) {
            return new ArrayList<>();
        }
        return this.backtrackingAlgorithm(1, cutOffNumber);
    }

    /**
     * 回溯算法
     *
     * @param headerPoint 标题点
     * @param tailPoint   尾点，尾点
     * @return {@code List<BinarySearchTreeNode>}
     */
    private List<BinarySearchTreeNode> backtrackingAlgorithm(int headerPoint, int tailPoint) {
        List<BinarySearchTreeNode> binarySearchTreeSearchesPointCollect = new ArrayList<>();
        if (headerPoint > tailPoint) {
            binarySearchTreeSearchesPointCollect.add(null);
            return binarySearchTreeSearchesPointCollect;
        }
        for (int i = headerPoint; i <= tailPoint; i++) {
            List<BinarySearchTreeNode> leftBinarySearchTreeNodePointCollect = this.backtrackingAlgorithm(headerPoint, i - 1);
            List<BinarySearchTreeNode> rightBinarySearchTreeNodePointCollect = this.backtrackingAlgorithm(i + 1, tailPoint);
            for (BinarySearchTreeNode leftBinarySearchTreeNodePoint : leftBinarySearchTreeNodePointCollect) {
                for (BinarySearchTreeNode rightBinarySearchTreeNodePoint : rightBinarySearchTreeNodePointCollect) {
                    BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode(i);
                    binarySearchTreeNode.leftTreeNode = leftBinarySearchTreeNodePoint;
                    binarySearchTreeNode.rightTreeNode = rightBinarySearchTreeNodePoint;
                    binarySearchTreeSearchesPointCollect.add(binarySearchTreeNode);
                }
            }
        }
        return binarySearchTreeSearchesPointCollect;
    }
}
