package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.PopulateNextRightNodePointerForEachNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PopulateNextRightNodePointerForEachNodeTest {

    private PopulateNextRightNodePointerForEachNode populateNextRightNodePointerForEachNodeUnderTest;

    @BeforeEach
    void setUp() {
        populateNextRightNodePointerForEachNodeUnderTest = new PopulateNextRightNodePointerForEachNode();
    }

    @Test
    void testUsedAlreadyExistsNodePointPopulateNextRightNodePointerForEachNode() {
        // Setup
        final PopulateNextRightNodePointerForEachNode.Node nodeRoot = new PopulateNextRightNodePointerForEachNode.Node(
                0, null, null, null);

        // Run the test
        final PopulateNextRightNodePointerForEachNode.Node result = populateNextRightNodePointerForEachNodeUnderTest.usedAlreadyExistsNodePointPopulateNextRightNodePointerForEachNode(
                nodeRoot);

        // Verify the results
    }
}
