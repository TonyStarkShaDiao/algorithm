package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.DiameterOfBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiameterOfBinaryTreeTest {

    private DiameterOfBinaryTree diameterOfBinaryTreeUnderTest;
    private DiameterOfBinaryTree.TreeNode treeNodeRoot;

    @BeforeEach
    void setUp() {
        diameterOfBinaryTreeUnderTest = new DiameterOfBinaryTree();
        treeNodeRoot = new DiameterOfBinaryTree.TreeNode(1);

        treeNodeRoot.rightTreeNode = new DiameterOfBinaryTree.TreeNode(2);
//        treeNodeRoot.leftTreeNode.leftTreeNode = new DiameterOfBinaryTree.TreeNode(4);
//        treeNodeRoot.leftTreeNode.rightTreeNode = new DiameterOfBinaryTree.TreeNode(5);
//        treeNodeRoot.rightTreeNode = new DiameterOfBinaryTree.TreeNode(3);
    }

    /**
     * 测验我自己的后序遍历发现直径
     */
    @Test
    void testMyself_PostorderTraversalFindDiameter() {

        final int result = diameterOfBinaryTreeUnderTest.myself_PostorderTraversalFindDiameter(treeNodeRoot);
        assertThat(result).isEqualTo(0);
    }
}
