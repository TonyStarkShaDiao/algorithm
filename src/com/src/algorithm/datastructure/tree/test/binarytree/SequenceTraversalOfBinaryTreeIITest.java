package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.SequenceTraversalOfBinaryTreeII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceTraversalOfBinaryTreeIITest {

    private SequenceTraversalOfBinaryTreeII sequenceTraversalOfBinaryTreeIIUnderTest;

    @BeforeEach
    void setUp() {
        sequenceTraversalOfBinaryTreeIIUnderTest = new SequenceTraversalOfBinaryTreeII();
    }

    @Test
    void testMySelf_bfsSequenceTraversalOfBinaryTreeII() {
        final SequenceTraversalOfBinaryTreeII.TreeNode treeNodeRoot = new SequenceTraversalOfBinaryTreeII.TreeNode(0);
        final List<List<Integer>> result = sequenceTraversalOfBinaryTreeIIUnderTest.mySelf_bfsSequenceTraversalOfBinaryTreeII(
                treeNodeRoot);
        assertThat(result).isEqualTo(Arrays.asList(Arrays.asList(0)));
    }
}
