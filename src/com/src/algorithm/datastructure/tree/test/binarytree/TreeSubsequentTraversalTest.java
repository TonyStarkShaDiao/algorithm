package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeFormerSequenceTraversal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeSubsequentTraversalTest {

    TreeFormerSequenceTraversal treeSubsequentTraversal;
    TreeFormerSequenceTraversal.TreeNode rootTreeNode;
    @BeforeEach
    void setUp() {
        treeSubsequentTraversal =new TreeFormerSequenceTraversal();
        rootTreeNode =new TreeFormerSequenceTraversal.TreeNode();
        TreeFormerSequenceTraversal.TreeNode treeNode1_1 = new TreeFormerSequenceTraversal.TreeNode(2);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2 = new TreeFormerSequenceTraversal.TreeNode(9);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2_1 = new TreeFormerSequenceTraversal.TreeNode(3);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2_2 = new TreeFormerSequenceTraversal.TreeNode(8);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2_2_1 = new TreeFormerSequenceTraversal.TreeNode(7);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2_2_2 = new TreeFormerSequenceTraversal.TreeNode(4);
        TreeFormerSequenceTraversal.TreeNode treeNode1_2_2_1_1 = new TreeFormerSequenceTraversal.TreeNode(6);
        rootTreeNode.leftTreeNode=treeNode1_1;
        rootTreeNode.rightTreeNode=treeNode1_2;
        treeNode1_1.leftTreeNode=treeNode1_2_1;
        treeNode1_1.rightTreeNode=treeNode1_2_2;
        treeNode1_2.leftTreeNode=treeNode1_2_2_1;
        treeNode1_2.rightTreeNode=treeNode1_2_2_2;
        treeNode1_2_1.rightTreeNode=treeNode1_2_2_1_1;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_StackTreeSubsequentTraversal() {
        List<Integer> list = treeSubsequentTraversal.myself_StackTreeFromTraversal(rootTreeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{0,9,4,7,2,8,3,6}, "栈方式后序遍历失败");
    }

    @Test
    void myself_RecursiveTreeSubsequentTraversal() {
        List<Integer> list = treeSubsequentTraversal.myself_RecursiveTreeSubsequentTraversal(rootTreeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{0,9,4,7,2,8,3,6}, "栈方式后序遍历失败");
    }
}