package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.AddBinarySearchTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddBinarySearchTreeNodeTest {

    public static final String ERROR_MESSAGE = "添加元素后的二叉搜索树未符合标准";
    AddBinarySearchTreeNode addBinarySearchTreeNode;
    AddBinarySearchTreeNode.BinarySearchTreeNode treeNode;
    Integer[]  expectArray;
    int addElement = 0;

    @BeforeEach
    void setUp() {
        expectArray= new Integer[]{4, 2, 7, 1, 3, 5};
        addElement=5;
        addBinarySearchTreeNode = new AddBinarySearchTreeNode();
        treeNode = new AddBinarySearchTreeNode.BinarySearchTreeNode(4);
        treeNode.leftTreeNode = new AddBinarySearchTreeNode.BinarySearchTreeNode(2);
        treeNode.rightTreeNode = new AddBinarySearchTreeNode.BinarySearchTreeNode(7);
        treeNode.leftTreeNode.leftTreeNode = new AddBinarySearchTreeNode.BinarySearchTreeNode(1);
        treeNode.leftTreeNode.rightTreeNode = new AddBinarySearchTreeNode.BinarySearchTreeNode(3);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void mySelf_TraverseAddBinarySearchTreeNode() {
        AddBinarySearchTreeNode.BinarySearchTreeNode addBinarySearchTreeNodeResult = addBinarySearchTreeNode.mySelf_TraverseAddBinarySearchTreeNode(treeNode, addElement);
        checkAddBinarySearchTreeNodeResults(addBinarySearchTreeNodeResult);
    }

    @Test
    void mySelf_SimpleTraverseAddBinarySearchTreeNode() {
        AddBinarySearchTreeNode.BinarySearchTreeNode addBinarySearchTreeNodeResult = addBinarySearchTreeNode.mySelf_SimpleTraverseAddBinarySearchTreeNode(treeNode, addElement);
        checkAddBinarySearchTreeNodeResults(addBinarySearchTreeNodeResult);

    }

    private void checkAddBinarySearchTreeNodeResults(AddBinarySearchTreeNode.BinarySearchTreeNode addBinarySearchTreeNodeResult) {
        Integer []  addBinarySearchTreeNodeArray = addBinarySearchTreeNode.binarySearchTreeNodeConvertArray(addBinarySearchTreeNodeResult);
        Assertions.assertArrayEquals(addBinarySearchTreeNodeArray,expectArray, ERROR_MESSAGE);
    }

    @Test
    void mySelf_LastTreeNodeBinarySearchTreeNode() {
        AddBinarySearchTreeNode.BinarySearchTreeNode addBinarySearchTreeNodeResult = addBinarySearchTreeNode.mySelf_LastTreeNodeBinarySearchTreeNode(treeNode, addElement);
        checkAddBinarySearchTreeNodeResults(addBinarySearchTreeNodeResult);
    }

    @Test
    void mySelf_RecursiveTreeNodeBinarySearchTreeNode() {
        AddBinarySearchTreeNode.BinarySearchTreeNode addBinarySearchTreeNodeResult = addBinarySearchTreeNode.mySelf_RecursiveTreeNodeBinarySearchTreeNode(treeNode, addElement);
        checkAddBinarySearchTreeNodeResults(addBinarySearchTreeNodeResult);
    }
}