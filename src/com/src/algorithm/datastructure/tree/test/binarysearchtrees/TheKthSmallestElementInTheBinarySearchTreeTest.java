package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.TheKthSmallestElementInTheBinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheKthSmallestElementInTheBinarySearchTreeTest {
    //
    private TheKthSmallestElementInTheBinarySearchTree theKthSmallestElementInTheBinarySearchTreeUnderTest;
    private TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode root;

    private int toConfigureKValue;
    private int expectedValue;

    @BeforeEach
    void setUp() {
        theKthSmallestElementInTheBinarySearchTreeUnderTest = new TheKthSmallestElementInTheBinarySearchTree();
        root = new TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode(50);
        root.leftTreeNode = new TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode(30);
        root.rightTreeNode = new TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode(70);
        root.leftTreeNode.leftTreeNode = new TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode(20);
        root.leftTreeNode.rightTreeNode = new TheKthSmallestElementInTheBinarySearchTree.BinarySearchTreeNode(40);
        toConfigureKValue = 2;
        expectedValue = 30;
    }

    @Test
    void testMySelf_middleOrderTraversalTheKthSmallestElementInTheBinarySearchTree() {
        // Run the test
        final int result = theKthSmallestElementInTheBinarySearchTreeUnderTest.mySelf_middleOrderTraversalTheKthSmallestElementInTheBinarySearchTree(
                root, toConfigureKValue);
        assertThat(result).isEqualTo(expectedValue);
    }
}
