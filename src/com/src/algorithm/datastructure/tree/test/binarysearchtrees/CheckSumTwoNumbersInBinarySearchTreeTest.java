package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.CheckSumTwoNumbersInBinarySearchTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckSumTwoNumbersInBinarySearchTreeTest {
    CheckSumTwoNumbersInBinarySearchTree checkSumTwoNumbersInBinarySearchTree;
    CheckSumTwoNumbersInBinarySearchTree.BinarySearchTreeNode binarySearchTreeNode;
    int checkSumValue = 0;

    @BeforeEach
    void setUp() {
        checkSumValue = 3;
        checkSumTwoNumbersInBinarySearchTree = new CheckSumTwoNumbersInBinarySearchTree();
        binarySearchTreeNode = new CheckSumTwoNumbersInBinarySearchTree.BinarySearchTreeNode(2);
        binarySearchTreeNode.leftTreeNode = new CheckSumTwoNumbersInBinarySearchTree.BinarySearchTreeNode(1);
        binarySearchTreeNode.rightTreeNode = new CheckSumTwoNumbersInBinarySearchTree.BinarySearchTreeNode(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void mySelf_BreadthFirstSearchCheckSumTwoNumbersInBinarySearchTree() {
        checkResult(checkSumTwoNumbersInBinarySearchTree.mySelf_BreadthFirstSearchCheckSumTwoNumbersInBinarySearchTree(binarySearchTreeNode, checkSumValue));
    }

    private void checkResult(Boolean checkResult) {
        Assertions.assertTrue(checkResult);
    }

    @Test
    void mySelf_depthFirstSearchAndDoublePointerCheckSumTwoNumbersInBinarySearchTree() {
        checkResult(checkSumTwoNumbersInBinarySearchTree.mySelf_depthFirstSearchAndDoublePointerCheckSumTwoNumbersInBinarySearchTree(binarySearchTreeNode, checkSumValue));

    }

    @Test
    void mySelf_SimpleCheckSumTwoNumbersInBinarySearchTree() {
        checkResult(checkSumTwoNumbersInBinarySearchTree.mySelf_SimpleCheckSumTwoNumbersInBinarySearchTree(binarySearchTreeNode, checkSumValue));
    }

    @Test
    void test() {
        boolean flag = false;
        int j=0;
        for (int i = 0; i < 10; i++) {
            System.out.println(j);
            System.out.println(flag);
            j = 4|1;
        }
        System.out.println(flag);
    }

    }

