package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversalTest {
    ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal;
    int[] preorderTraversalArray;
    int[] middleOrderTraversalArray;
    ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode expectTreeNode;

    @BeforeEach
    void setUp() {
        constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal();
        preorderTraversalArray = new int[]{3, 9, 20, 15, 7};
        middleOrderTraversalArray = new int[]{9, 3, 15, 20, 7};
        expectTreeNode = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode(3);
        expectTreeNode.leftTreeNode = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode(9);
        expectTreeNode.rightTreeNode = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode(20);
        expectTreeNode.rightTreeNode.leftTreeNode = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode(15);
        expectTreeNode.rightTreeNode.rightTreeNode = new ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode(7);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildTree() {
        ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode treeNode = constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.buildTree(preorderTraversalArray, middleOrderTraversalArray);
        Assertions.assertEquals(expectTreeNode, treeNode);
    }

    @Test
    void mySelf_RecursionBuildTree() {
        ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode treeNode = constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.mySelf_RecursionBuildTree(preorderTraversalArray, middleOrderTraversalArray);
        Assertions.assertEquals(expectTreeNode, treeNode);

    }

    @Test
    void mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal() {
        ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode treeNode = constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(preorderTraversalArray, middleOrderTraversalArray);
        Assertions.assertEquals(expectTreeNode, treeNode);
    }

    @Test
    void buildTree2() {
        ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode treeNode = constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.buildTree2(preorderTraversalArray, middleOrderTraversalArray);
        Assertions.assertEquals(expectTreeNode, treeNode);
    }

    @Test
    void mySelf_ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal() {
        ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.TreeNode treeNode = constructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal.mySelf_ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(preorderTraversalArray, middleOrderTraversalArray);
        Assertions.assertEquals(expectTreeNode, treeNode);

    }
}