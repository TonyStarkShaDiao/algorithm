package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeSubsequentTraversal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeFormerSequenceTraversalTest {
        TreeSubsequentTraversal treeFormerSequenceTraversal;
        TreeSubsequentTraversal.TreeNode rootTreeNode;
    @BeforeEach
    void setUp() {
        treeFormerSequenceTraversal =new TreeSubsequentTraversal();
        rootTreeNode =new TreeSubsequentTraversal.TreeNode(1);
        TreeSubsequentTraversal.TreeNode treeNode1_1 = new TreeSubsequentTraversal.TreeNode(3);
        TreeSubsequentTraversal.TreeNode treeNode1_2 = new TreeSubsequentTraversal.TreeNode(5);
        TreeSubsequentTraversal.TreeNode treeNode1_2_1 = new TreeSubsequentTraversal.TreeNode(6);
        TreeSubsequentTraversal.TreeNode treeNode1_2_2 = new TreeSubsequentTraversal.TreeNode(7);
        TreeSubsequentTraversal.TreeNode treeNode1_2_2_1 = new TreeSubsequentTraversal.TreeNode(8);
        TreeSubsequentTraversal.TreeNode treeNode1_2_2_2 = new TreeSubsequentTraversal.TreeNode(5);
        TreeSubsequentTraversal.TreeNode treeNode1_2_2_1_1 = new TreeSubsequentTraversal.TreeNode(2);
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
    void myself_ReverseStackTreeFormerSequenceTraversal() {
        List<Integer> list = treeFormerSequenceTraversal.myself_ReverseStackTreeTreeSubsequentTraversal(rootTreeNode);
        Integer[] arrayResult =new Integer[list.size()];
         list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{2,6,7,3,8,5,5,1}, "栈方式前序遍历失败");
    }

    @Test
    void myself_RecursiveTreeFormerSequenceTraversal() {
        List<Integer> list = treeFormerSequenceTraversal.myself_RecursiveTreeSubsequentTraversal(rootTreeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{2,6,7,3,8,5,5,1}, "栈方式前序遍历失败");
    }
    @Test
    void myself_StackTreeFormerSequenceTraversal() {
        List<Integer> list = treeFormerSequenceTraversal.myself_StackTreeTreeSubsequentTraversal(rootTreeNode);
        Integer[] arrayResult =new Integer[list.size()];
        list.toArray(arrayResult);
        assertArrayEquals(arrayResult,new Integer[]{2,6,7,3,8,5,5,1}, "栈方式前序遍历失败");
    }
}