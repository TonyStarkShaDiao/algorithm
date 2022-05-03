package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.BinaryTreeSawtoothLevelOrderTraversal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeSawtoothLevelOrderTraversalTest {

    private BinaryTreeSawtoothLevelOrderTraversal binaryTreeSawtoothLevelOrderTraversalUnderTest;
    private BinaryTreeSawtoothLevelOrderTraversal.TreeNode root;
    private List<List<Integer>> expectedCollect;

    @BeforeEach
    void setUp() {
        binaryTreeSawtoothLevelOrderTraversalUnderTest = new BinaryTreeSawtoothLevelOrderTraversal();
        root = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(0);
        root.leftTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(1);
        root.rightTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(2);
        root.leftTreeNode.leftTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(3);
        root.leftTreeNode.rightTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(4);
        root.rightTreeNode.leftTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(5);
        root.rightTreeNode.rightTreeNode = new BinaryTreeSawtoothLevelOrderTraversal.TreeNode(6);
        expectedCollect = new ArrayList<>();
        expectedCollect.add(Arrays.asList(0));
        expectedCollect.add(Arrays.asList(2, 1));
        expectedCollect.add(Arrays.asList(3, 4, 5, 6));
    }

    @Test
    void testMySelf_BinaryTreeSawtoothLLLevelOrderTraversal() {
        final List<List<Integer>> result = binaryTreeSawtoothLevelOrderTraversalUnderTest.mySelf_BinaryTreeSawtoothLLLevelOrderTraversal(
                root);
        assertThat(result).isEqualTo(expectedCollect);
    }
}
