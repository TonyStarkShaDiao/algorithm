package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.RightViewOfBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RightViewOfBinaryTreeTest {

    private RightViewOfBinaryTree rightViewOfBinaryTreeUnderTest;
    private RightViewOfBinaryTree.TreeNode root;
    private List<Integer> expectedCollect;

    @BeforeEach
    void setUp() {
        rightViewOfBinaryTreeUnderTest = new RightViewOfBinaryTree();
        root = new RightViewOfBinaryTree.TreeNode(5);
        root.leftTreeNode = new RightViewOfBinaryTree.TreeNode(3);
        root.rightTreeNode = new RightViewOfBinaryTree.TreeNode(7);
        root.leftTreeNode.leftTreeNode = new RightViewOfBinaryTree.TreeNode(2);
        root.leftTreeNode.rightTreeNode = new RightViewOfBinaryTree.TreeNode(4);
        root.rightTreeNode.leftTreeNode = new RightViewOfBinaryTree.TreeNode(6);
        root.rightTreeNode.rightTreeNode = new RightViewOfBinaryTree.TreeNode(8);
        expectedCollect = Arrays.asList(5, 7, 8);

    }

    @Test
    void testMySelf_BFSRightViewOfBinaryTree() {
        final List<Integer> result = rightViewOfBinaryTreeUnderTest.mySelf_BFSRightViewOfBinaryTree(root);
        // Verify the results
        assertThat(result).isEqualTo(expectedCollect);
    }
}
