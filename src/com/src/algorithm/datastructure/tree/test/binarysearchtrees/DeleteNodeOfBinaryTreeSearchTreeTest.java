package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.DeleteNodeOfBinaryTreeSearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteNodeOfBinaryTreeSearchTreeTest {

    public static final int DEL_ELEMENT = 50;
    private DeleteNodeOfBinaryTreeSearchTree deleteNodeOfBinaryTreeSearchTreeUnderTest;
    private DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode root;
    private DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode expectRoot;

    @BeforeEach
    void setUp() {
        deleteNodeOfBinaryTreeSearchTreeUnderTest = new DeleteNodeOfBinaryTreeSearchTree();
        root = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(50);
        root.leftTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(30);
        root.rightTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(70);
        root.leftTreeNode.rightTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(40);
        root.rightTreeNode.leftTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(60);
        root.rightTreeNode.rightTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(80);
        expectRoot = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(60);
        expectRoot.leftTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(30);
        expectRoot.rightTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(70);
        expectRoot.leftTreeNode.rightTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(40);
        expectRoot.rightTreeNode.leftTreeNode = new DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode(80);


    }

    @Test
    void testIterationDeleteNodeOfBinaryTreeSearchTree() {
        final DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode result = deleteNodeOfBinaryTreeSearchTreeUnderTest.iterationDeleteNodeOfBinaryTreeSearchTree(
                root, DEL_ELEMENT);
        assertThat(result).isEqualTo(expectRoot);
    }

    @Test
    void TestdeleteNode() {
        final DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode result = deleteNodeOfBinaryTreeSearchTreeUnderTest.deleteNode(
                root, DEL_ELEMENT);
        assertThat(result).isEqualTo(expectRoot);
    }

    @Test
    void mySelf_secondIteration() {
        DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode result = deleteNodeOfBinaryTreeSearchTreeUnderTest.mySelf_secondIteration(root, DEL_ELEMENT);
        assertThat(result).isEqualTo(expectRoot);
    }

    @Test
    void mySelf_thirdIteration() {
        DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode result = deleteNodeOfBinaryTreeSearchTreeUnderTest.mySelf_thirdIteration(root, DEL_ELEMENT);
        assertThat(result).isEqualTo(expectRoot);
    }

    @Test
    void mySelf_fourthIterationDeleteTreeNodeElement() {
        DeleteNodeOfBinaryTreeSearchTree.BinarySearchTreeNode result = deleteNodeOfBinaryTreeSearchTreeUnderTest.mySelf_fourthIterationDeleteTreeNodeElement(root, DEL_ELEMENT);
        assertThat(result).isEqualTo(expectRoot);
    }
}
