package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequencesTest {

    private ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences constructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequencesUnderTest;

    @BeforeEach
    void setUp() {
        constructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequencesUnderTest = new ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences();
    }

    @Test
    void testBuildTree() {
        // Setup
        final ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences.TreeNode expectedResult = new ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences.TreeNode(
                0, null, null);

        // Run the test
        final ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences.TreeNode result = constructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequencesUnderTest.buildTree(
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
