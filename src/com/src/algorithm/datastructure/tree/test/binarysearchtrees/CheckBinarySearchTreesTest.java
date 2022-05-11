package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.BinarySearchTreeSearch;
import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.CheckBinarySearchTrees;
import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.OrderedArrayToBinarySearchTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckBinarySearchTreesTest {
    CheckBinarySearchTrees checkBinarySearchTrees;
    CheckBinarySearchTrees.BinarySearchTreeNode treeNodeRoot;
    @BeforeEach
    void setUp() {
        checkBinarySearchTrees = new CheckBinarySearchTrees();
        treeNodeRoot = new CheckBinarySearchTrees.BinarySearchTreeNode(5);
        treeNodeRoot.leftTreeNode = new CheckBinarySearchTrees.BinarySearchTreeNode(1);
        treeNodeRoot.leftTreeNode.rightTreeNode = new CheckBinarySearchTrees.BinarySearchTreeNode(3);
        treeNodeRoot.rightTreeNode = new CheckBinarySearchTrees.BinarySearchTreeNode(6);
        treeNodeRoot.rightTreeNode.rightTreeNode = new CheckBinarySearchTrees.BinarySearchTreeNode(7);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_MiddleSequenceTraverseCheckBinarySearchTrees() {
        Boolean binarySearchTreesCheckResult = checkBinarySearchTrees.mySelf_MiddleSequenceTraverseCheckBinarySearchTrees(treeNodeRoot);
        assertTrue(binarySearchTreesCheckResult, "结果不是二叉搜索树BTS");
    }

    @Test
    void mySelf_RecursiveTraverseCheckBinarySearchTrees() {
        Boolean binarySearchTreesCheckResult = checkBinarySearchTrees.mySelf_RecursiveCheckBinarySearchTrees(treeNodeRoot);
        assertTrue(binarySearchTreesCheckResult, "结果不是二叉搜索树BTS");
    }

    @Test
    void testMySelf_MiddleSequenceTraverseCheckBinarySearchTrees() {
        Boolean binarySearchTreesCheckResult = checkBinarySearchTrees.mySelf_RecursiveDepthFirstSearchCheckBinarySearchTrees(treeNodeRoot);
        assertTrue(binarySearchTreesCheckResult, "结果不是二叉搜索树BTS");
    }


}