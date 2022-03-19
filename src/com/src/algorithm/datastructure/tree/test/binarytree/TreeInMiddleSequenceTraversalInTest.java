package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeInMiddleSequenceTraversalIn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeInMiddleSequenceTraversalInTest {

    public static final String ITERATION_ERROR_MESSAGE = "栈方式中序遍历失败";
    public static final String RECURSIVE_ERROR_MESSAGE = "递归方式中序遍历失败";
    TreeInMiddleSequenceTraversalIn.TreeNode treeNode;
    TreeInMiddleSequenceTraversalIn  TreeInMiddleSequenceTraversalIn;
    @BeforeEach
    void setUp() {
        TreeInMiddleSequenceTraversalIn =new TreeInMiddleSequenceTraversalIn();
        treeNode =new TreeInMiddleSequenceTraversalIn.TreeNode();
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_1 = new TreeInMiddleSequenceTraversalIn.TreeNode(2);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2 = new TreeInMiddleSequenceTraversalIn.TreeNode(9);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_1 = new TreeInMiddleSequenceTraversalIn.TreeNode(3);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2 = new TreeInMiddleSequenceTraversalIn.TreeNode(8);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2_1 = new TreeInMiddleSequenceTraversalIn.TreeNode(7);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2_2 = new TreeInMiddleSequenceTraversalIn.TreeNode(4);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2_1_1 = new TreeInMiddleSequenceTraversalIn.TreeNode(6);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2_1_2 = new TreeInMiddleSequenceTraversalIn.TreeNode(7);
      TreeInMiddleSequenceTraversalIn.TreeNode treeNode1_2_2_1_2_1 = new TreeInMiddleSequenceTraversalIn.TreeNode(13);
        treeNode.leftTreeNode=treeNode1_1;
        treeNode.rightTreeNode=treeNode1_2;
        treeNode1_1.leftTreeNode=treeNode1_2_1;
        treeNode1_1.rightTreeNode=treeNode1_2_2;
        treeNode1_2.leftTreeNode=treeNode1_2_2_1;
        treeNode1_2.rightTreeNode=treeNode1_2_2_2;
        treeNode1_2_1.leftTreeNode=treeNode1_2_2_1_1;
        treeNode1_2_2_1_1.rightTreeNode=treeNode1_2_2_1_2;
        treeNode1_2_2_1_1.leftTreeNode=treeNode1_2_2_1_2_1;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_IterationInMiddleSequenceTraversalIn() {
        System.out.println();
        List<Integer> list = TreeInMiddleSequenceTraversalIn.mySelf_IterationInMiddleSequenceTraversalIn(treeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{13,6,7,3,2,8,0,7,9,4}, ITERATION_ERROR_MESSAGE);
    }

    @Test
    void mySelf_RecursiveInMiddleSequenceTraversalIn() {
        System.out.println();
        List<Integer> list = TreeInMiddleSequenceTraversalIn.mySelf_RecursiveInMiddleSequenceTraversalIn(treeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{3,6,2,8,0,7,9,4}, RECURSIVE_ERROR_MESSAGE);
    }
}