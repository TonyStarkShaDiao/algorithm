package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.AddBinarySearchTreeNode;
import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.BinarySearchTreeIntoBalancedBinarySearchTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeIntoBalancedBinarySearchTreeTest {

    BinarySearchTreeIntoBalancedBinarySearchTree binarySearchTreeIntoBalancedBinarySearchTree;
    BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode binarySearchTreeNode;

    @BeforeEach
    void setUp() {
        binarySearchTreeIntoBalancedBinarySearchTree = new BinarySearchTreeIntoBalancedBinarySearchTree();
        binarySearchTreeNode = new BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode(1);
        binarySearchTreeNode.rightTreeNode = new BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode(2);
        binarySearchTreeNode.rightTreeNode.rightTreeNode = new BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode(3);
        binarySearchTreeNode.rightTreeNode.rightTreeNode.rightTreeNode = new BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode(4);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_ArrayBinarySearchTreeIntoBalancedBinarySearchTree() {
        BinarySearchTreeIntoBalancedBinarySearchTree.BinarySearchTreeNode completeBalancedBinaryTree = binarySearchTreeIntoBalancedBinarySearchTree.mySelf_ArrayBinarySearchTreeIntoBalancedBinarySearchTree(binarySearchTreeNode);
        System.out.println(completeBalancedBinaryTree.toString());
    }
}