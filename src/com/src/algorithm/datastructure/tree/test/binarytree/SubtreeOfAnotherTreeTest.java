package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.SubtreeOfAnotherTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtreeOfAnotherTreeTest {

    private SubtreeOfAnotherTree subtreeOfAnotherTreeUnderTest;
    private SubtreeOfAnotherTree.TreeNode targetTreeNodeRoot;
    private SubtreeOfAnotherTree.TreeNode needCheckSubTree;

    @BeforeEach
    void setUp() {
        subtreeOfAnotherTreeUnderTest = new SubtreeOfAnotherTree();
        targetTreeNodeRoot = new SubtreeOfAnotherTree.TreeNode(3);
        targetTreeNodeRoot.leftTreeNode = new SubtreeOfAnotherTree.TreeNode(4);
        targetTreeNodeRoot.leftTreeNode.leftTreeNode = new SubtreeOfAnotherTree.TreeNode(1);
        targetTreeNodeRoot.leftTreeNode.rightTreeNode = new SubtreeOfAnotherTree.TreeNode(2);
        targetTreeNodeRoot.leftTreeNode.rightTreeNode.rightTreeNode = new SubtreeOfAnotherTree.TreeNode(0);
        targetTreeNodeRoot.rightTreeNode = new SubtreeOfAnotherTree.TreeNode(5);
        needCheckSubTree = new SubtreeOfAnotherTree.TreeNode(4);
        needCheckSubTree.leftTreeNode = new SubtreeOfAnotherTree.TreeNode(1);
        needCheckSubTree.rightTreeNode = new SubtreeOfAnotherTree.TreeNode(2);

    }

    @Test
    void testIsSubtree() {
        // Setup

        // Run the test
        final boolean result = subtreeOfAnotherTreeUnderTest.isSubtree(targetTreeNodeRoot, needCheckSubTree);

        // Verify the results
        assertThat(result).isTrue();
    }
}
