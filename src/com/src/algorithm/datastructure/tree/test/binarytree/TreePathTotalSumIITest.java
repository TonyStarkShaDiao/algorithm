package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreePathTotalSumII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreePathTotalSumIITest {

    private TreePathTotalSumII treePathTotalSumIIUnderTest;
    private TreePathTotalSumII.TreeNode treeNodeRoot;
    private List<List<Integer>> expectedCollectResult;

    @BeforeEach
    void setUp() {
        expectedCollectResult = new ArrayList<>();
        expectedCollectResult.add(Arrays.asList(5, 4, 11, 2));
        expectedCollectResult.add(Arrays.asList(5, 8, 4, 5));
        treePathTotalSumIIUnderTest = new TreePathTotalSumII();
        treeNodeRoot = new TreePathTotalSumII.TreeNode(5);
        treeNodeRoot.leftTreeNode = new TreePathTotalSumII.TreeNode(4);
        treeNodeRoot.rightTreeNode = new TreePathTotalSumII.TreeNode(8);
        treeNodeRoot.rightTreeNode.leftTreeNode = new TreePathTotalSumII.TreeNode(13);
        treeNodeRoot.rightTreeNode.rightTreeNode = new TreePathTotalSumII.TreeNode(4);
        treeNodeRoot.rightTreeNode.rightTreeNode.leftTreeNode = new TreePathTotalSumII.TreeNode(5);
        treeNodeRoot.rightTreeNode.rightTreeNode.rightTreeNode = new TreePathTotalSumII.TreeNode(1);
        treeNodeRoot.leftTreeNode.leftTreeNode = new TreePathTotalSumII.TreeNode(11);
        treeNodeRoot.leftTreeNode.leftTreeNode.leftTreeNode = new TreePathTotalSumII.TreeNode(7);
        treeNodeRoot.leftTreeNode.leftTreeNode.rightTreeNode = new TreePathTotalSumII.TreeNode(2);
    }

    @Test
    void testMySelf_HashTreePathTotalSumII() {
        final List<List<Integer>> result = treePathTotalSumIIUnderTest.mySelf_HashTreePathTotalSumII(treeNodeRoot, 22);
        assertThat(result).isEqualTo(expectedCollectResult);
    }
}
