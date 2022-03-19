package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeLevelTraversal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TreeLevelTraversalTest {

    TreeLevelTraversal.TreeNode treeNode;
    TreeLevelTraversal treeLevelTraversal;

    @BeforeEach
    void setUp() {
        treeLevelTraversal = new TreeLevelTraversal();
        treeNode = new TreeLevelTraversal.TreeNode();
        TreeLevelTraversal.TreeNode treeNode1_1 = new TreeLevelTraversal.TreeNode(2);
        TreeLevelTraversal.TreeNode treeNode1_2 = new TreeLevelTraversal.TreeNode(9);
        TreeLevelTraversal.TreeNode treeNode1_2_1 = new TreeLevelTraversal.TreeNode(3);
        TreeLevelTraversal.TreeNode treeNode1_2_2 = new TreeLevelTraversal.TreeNode(8);
        TreeLevelTraversal.TreeNode treeNode1_2_2_1 = new TreeLevelTraversal.TreeNode(7);
        TreeLevelTraversal.TreeNode treeNode1_2_2_2 = new TreeLevelTraversal.TreeNode(4);
        TreeLevelTraversal.TreeNode treeNode1_2_2_1_1 = new TreeLevelTraversal.TreeNode(6);
        TreeLevelTraversal.TreeNode treeNode1_2_2_1_2 = new TreeLevelTraversal.TreeNode(7);
        TreeLevelTraversal.TreeNode treeNode1_2_2_1_2_1 = new TreeLevelTraversal.TreeNode(13);
        treeNode.rightTreeNode = treeNode1_2;
        treeNode1_1.leftTreeNode = treeNode1_2_1;
        treeNode1_1.rightTreeNode = treeNode1_2_2;
        treeNode1_2.leftTreeNode = treeNode1_2_2_1;
        treeNode1_2.rightTreeNode = treeNode1_2_2_2;
        treeNode1_2_1.leftTreeNode = treeNode1_2_2_1_1;
        treeNode1_2_2_1_1.rightTreeNode = treeNode1_2_2_1_2;
        treeNode1_2_2_1_1.leftTreeNode = treeNode1_2_2_1_2_1;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_QueueLevelTraversal() {
        List<List<Integer>> elementLevelList = treeLevelTraversal.myself_QueueLevelTraversal(treeNode);
        int[] treeNodeElementArray = twoDimensionArrayConvertArray(elementLevelList);
        Assertions.assertArrayEquals(treeNodeElementArray, new int[]{0, 9, 7, 4}, "错误数组为"+Arrays.toString(treeNodeElementArray));
    }

    /**
     * 二维数组转换为数组
     *
     * @param elementLevelList 元素水平列表
     */
    private int[] twoDimensionArrayConvertArray(List<List<Integer>> elementLevelList) {
        int arraysSize = 0;
        for (int elementLevelListIndex = 0; elementLevelListIndex < elementLevelList.size(); elementLevelListIndex++) {
            List<Integer> elementCollect = elementLevelList.get(elementLevelListIndex);
            for (int elementCollectIndex = 0; elementCollectIndex < elementCollect.size(); elementCollectIndex++) {
                arraysSize++;
            }
        }
        int elementArrayIndex = 0;
        int[] elementArray = new int[arraysSize];
        for (int elementLevelListIndex = 0; elementLevelListIndex < elementLevelList.size(); elementLevelListIndex++) {
            List<Integer> elementCollect = elementLevelList.get(elementLevelListIndex);
            for (Integer integer : elementCollect) {
                elementArray[elementArrayIndex++] = integer;
            }
        }
        return elementArray;
    }

    @Test
    void myself_RecursiveLevelTraversal() {
        List<List<Integer>> elementLevelList = treeLevelTraversal.myself_RecursiveLevelTraversal(treeNode);
        int[] treeNodeElementArray = twoDimensionArrayConvertArray(elementLevelList);
        Assertions.assertArrayEquals(treeNodeElementArray, new int[]{0, 9, 7, 4});
    }
}