package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.SumOfBinaryNumbersFromRootToLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfBinaryNumbersFromRootToLeafTest {

    private SumOfBinaryNumbersFromRootToLeaf sumOfBinaryNumbersFromRootToLeafUnderTest;
    SumOfBinaryNumbersFromRootToLeaf.TreeNode root;

    @BeforeEach
    void setUp() {
        sumOfBinaryNumbersFromRootToLeafUnderTest = new SumOfBinaryNumbersFromRootToLeaf();
        root = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(1);
        root.leftTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(0);
        root.rightTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(1);
        root.leftTreeNode.leftTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(0);
        root.leftTreeNode.rightTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(1);
        root.rightTreeNode.leftTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(0);
        root.rightTreeNode.rightTreeNode = new SumOfBinaryNumbersFromRootToLeaf.TreeNode(1);

    }

    @Test
    void testPreorderTraversalSumOfBinaryNumbersFromRootToLeaf() {
        final int result = sumOfBinaryNumbersFromRootToLeafUnderTest.preorderTraversalSumOfBinaryNumbersFromRootToLeaf(
                root);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
