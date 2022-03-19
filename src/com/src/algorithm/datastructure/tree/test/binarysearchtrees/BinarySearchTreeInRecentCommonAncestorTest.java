package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.BinarySearchTreeInRecentCommonAncestor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeInRecentCommonAncestorTest {

    public static final String CHECK_BINARY_SEARCH_TREE_ERROR_MESSAGE = "当前二叉树不是二叉搜索树";
    BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode binarySearchTreeNodeRoot;
    BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode firstOneSearchTreeNode;
    BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode secondSearchTreeNode;
        BinarySearchTreeInRecentCommonAncestor binarySearchTreeInRecentCommonAncestor;
    BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode binarySearchTreeNode;
    @BeforeEach
    void setUp() {
        binarySearchTreeInRecentCommonAncestor =new BinarySearchTreeInRecentCommonAncestor();
        binarySearchTreeNodeRoot = new BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode(5);
        firstOneSearchTreeNode = new BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode(1);
        secondSearchTreeNode = new BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode(4);

        binarySearchTreeNodeRoot.leftTreeNode = new BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode(3);
        binarySearchTreeNodeRoot.rightTreeNode = new BinarySearchTreeInRecentCommonAncestor.BinarySearchTreeNode(9);
        binarySearchTreeNodeRoot.leftTreeNode.leftTreeNode = firstOneSearchTreeNode;
        binarySearchTreeNodeRoot.leftTreeNode.rightTreeNode = secondSearchTreeNode;
        Boolean result= binarySearchTreeInRecentCommonAncestor.checkBinarySearchTreeNode(binarySearchTreeNodeRoot);
        Assertions.assertTrue(result, CHECK_BINARY_SEARCH_TREE_ERROR_MESSAGE);
    }

    @AfterEach
    void tearDown() {
//        Assertions.assertEquals(binarySearchTreeNode.value,3,"最近公共祖先为3,答案错误:"+binarySearchTreeNode.value);
    }

    @Test
    void mySelf_onceTraverseBinarySearchTreeInRecentCommonAncestor() {
        binarySearchTreeNode = binarySearchTreeInRecentCommonAncestor.mySelf_onceTraverseBinarySearchTreeInRecentCommonAncestor(binarySearchTreeNodeRoot, firstOneSearchTreeNode, secondSearchTreeNode);

    }

    @Test
    void mySelf_TwoTraverseBinarySearchTreeInRecentCommonAncestor() {
        binarySearchTreeNode = binarySearchTreeInRecentCommonAncestor.mySelf_TwoTraverseBinarySearchTreeInRecentCommonAncestor(binarySearchTreeNodeRoot, firstOneSearchTreeNode, secondSearchTreeNode);

    }
}