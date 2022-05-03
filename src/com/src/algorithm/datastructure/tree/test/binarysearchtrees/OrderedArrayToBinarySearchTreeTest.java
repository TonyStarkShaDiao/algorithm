package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.OrderedArrayToBinarySearchTree;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedArrayToBinarySearchTreeTest {

    OrderedArrayToBinarySearchTree orderedArrayToBinarySearchTree;
    OrderedArrayToBinarySearchTree.BinarySearchTreeNode root;
    int[] orderArray;

    @BeforeEach
    void setUp() {
        orderedArrayToBinarySearchTree = new OrderedArrayToBinarySearchTree();
        root = new OrderedArrayToBinarySearchTree.BinarySearchTreeNode(10);
        root.leftTreeNode = new OrderedArrayToBinarySearchTree.BinarySearchTreeNode(5);
        root.leftTreeNode.leftTreeNode = new OrderedArrayToBinarySearchTree.BinarySearchTreeNode(3);
        root.rightTreeNode = new OrderedArrayToBinarySearchTree.BinarySearchTreeNode(7);
        orderArray = new int[]{3, 5, 7, 10};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_RecursionOrderedArrayToBinarySearchTree() {
        OrderedArrayToBinarySearchTree.BinarySearchTreeNode binarySearchTreeNode = orderedArrayToBinarySearchTree.Myself_RecursionOrderedArrayToBinarySearchTree(orderArray);
        Boolean checkBinarySearchTreeResult = orderedArrayToBinarySearchTree.middleOrderTraversalCheckBinarySearchTree(binarySearchTreeNode);
        assertTrue(checkBinarySearchTreeResult);
    }

    @Test
    void middleOrderTraversalCheckBinarySearchTree() {
        Boolean checkBinarySearchTreeResult = orderedArrayToBinarySearchTree.middleOrderTraversalCheckBinarySearchTree(root);
        assertTrue(checkBinarySearchTreeResult);
    }
}