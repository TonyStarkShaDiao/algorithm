package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreePathTotalSum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreePathTotalSumTest {

TreePathTotalSum treePathTotalSum;   
TreePathTotalSum.TreeNode treeNode;
    @BeforeEach
    void setUp() {
        treePathTotalSum =new TreePathTotalSum();
        treeNode =new TreePathTotalSum.TreeNode(1);
        treeNode.leftTreeNode=new TreePathTotalSum.TreeNode(2);
        treeNode.rightTreeNode=new TreePathTotalSum.TreeNode(4);
        treeNode.rightTreeNode.leftTreeNode=new TreePathTotalSum.TreeNode(5);
        treeNode.rightTreeNode.rightTreeNode=new TreePathTotalSum.TreeNode(7);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_DepthFirstSearchHasTreePathTotalSum() {
        Boolean CheckTreePathTotalFlag = treePathTotalSum.mySelf_DepthFirstSearchHasTreePathTotalSum(treeNode, 10);
        checkTreePathTotalResult(CheckTreePathTotalFlag);
    }

    private void checkTreePathTotalResult(Boolean CheckTreePathTotalResult) {
        Assertions.assertTrue(CheckTreePathTotalResult,"树的路径总和为10,结果为true,不匹配为false");
    }

    @Test
    void mySelf_BreadthFirstSearchHasTreePathTotalSum() {
        Boolean CheckTreePathTotalFlag = treePathTotalSum.mySelf_BreadthFirstSearchHasTreePathTotalSum(treeNode, 10);
        checkTreePathTotalResult(CheckTreePathTotalFlag);
    }

    @Test
    void mySelf_RecursiveHasTreePathTotalSum() {
        Boolean CheckTreePathTotalFlag = treePathTotalSum.mySelf_RecursiveHasTreePathTotalSum(treeNode, 10);
        checkTreePathTotalResult(CheckTreePathTotalFlag);
    }
}