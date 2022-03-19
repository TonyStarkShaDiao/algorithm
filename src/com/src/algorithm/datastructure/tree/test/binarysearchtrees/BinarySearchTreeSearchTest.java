package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.BinarySearchTreeSearch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeSearchTest {

    public static final String MESSAGE_TREE_NODE_EMPTY = "查找的节点是空的";
    public static final String MESSAGE_EXPECT_RESULT = "期望结果为213";
    BinarySearchTreeSearch binarySearchTreeSearch;
    BinarySearchTreeSearch.BinarySearchTreeNode treeNodeRoot;
    int binarySearchTreesMatchingNodeValue=0;
    @BeforeEach
    void setUp() {
        binarySearchTreeSearch =new BinarySearchTreeSearch();
        binarySearchTreesMatchingNodeValue=2;
        treeNodeRoot =new BinarySearchTreeSearch.BinarySearchTreeNode(4);
        treeNodeRoot.leftTreeNode=new BinarySearchTreeSearch.BinarySearchTreeNode(2);
        treeNodeRoot.rightTreeNode=new BinarySearchTreeSearch.BinarySearchTreeNode(7);
        treeNodeRoot.leftTreeNode.leftTreeNode =new BinarySearchTreeSearch.BinarySearchTreeNode(1);
        treeNodeRoot.leftTreeNode.rightTreeNode =new BinarySearchTreeSearch.BinarySearchTreeNode(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_TraverseBinarySearchTreeSearch() {
        BinarySearchTreeSearch.BinarySearchTreeNode binarySearchTreeNode = binarySearchTreeSearch.mySelf_TraverseBinarySearchTreeSearch(treeNodeRoot, binarySearchTreesMatchingNodeValue);
        checkBinarySearchTreeSearchResult(binarySearchTreeNode);

    }

    private void checkBinarySearchTreeSearchResult(BinarySearchTreeSearch.BinarySearchTreeNode binarySearchTreeNode) {
        Assertions.assertNotNull(binarySearchTreeNode, MESSAGE_TREE_NODE_EMPTY);
        Integer[] binarySearchTreeSearchElementArray = binarySearchTreeSearch.TraverseBinarySearchTreeSearchConvertArrayBFS(binarySearchTreeNode);
        Assertions.assertArrayEquals(binarySearchTreeSearchElementArray, new Integer[]{2,1,3}, MESSAGE_EXPECT_RESULT);
    }

    @Test
    void mySelf_RecursiveBinarySearchTreeSearch() {
        BinarySearchTreeSearch.BinarySearchTreeNode binarySearchTreeNode = binarySearchTreeSearch.mySelf_RecursiveBinarySearchTreeSearch(treeNodeRoot, binarySearchTreesMatchingNodeValue);
        checkBinarySearchTreeSearchResult(binarySearchTreeNode);

    }
}