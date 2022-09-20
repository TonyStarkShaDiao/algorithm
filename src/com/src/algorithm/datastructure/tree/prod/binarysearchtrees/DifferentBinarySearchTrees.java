package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

/**
 * 不同二叉搜索树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/25
 */
public class DifferentBinarySearchTrees {
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
     * 我自动态规划不同二进制搜索树
     *
     * @param elementsWithinACertainValue 某个值内元素
     * @return int
     */
    public int mySelf_dynamicProgrammingDifferentBinarySearchTrees(int elementsWithinACertainValue) {
        int[] currentValueIsRootAppearingCountArray = new int[elementsWithinACertainValue + 1];
        currentValueIsRootAppearingCountArray[0] = 1;//0个元素的二叉搜索树只有一种,即空树
        currentValueIsRootAppearingCountArray[1] = 1;//1个元素的二叉搜索树只有一种,即只有一个根节点
        for (int i = 2; i <= elementsWithinACertainValue; ++i) {
            for (int j = 1; j <= i; ++j) {
                currentValueIsRootAppearingCountArray[i] = currentValueIsRootAppearingCountArray[j - 1] * currentValueIsRootAppearingCountArray[i - j];
            }
        }
        return currentValueIsRootAppearingCountArray[elementsWithinACertainValue];
    }
}
