package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.SerializeAndDeserializeBinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SerializeAndDeserializeBinarySearchTreeTest {
    private SerializeAndDeserializeBinarySearchTree.BinarySearchTreeNode root;

    private SerializeAndDeserializeBinarySearchTree serializeAndDeserializeBinarySearchTreeUnderTest;

    @BeforeEach
    void setUp() {
        serializeAndDeserializeBinarySearchTreeUnderTest = new SerializeAndDeserializeBinarySearchTree();
        root = new SerializeAndDeserializeBinarySearchTree.BinarySearchTreeNode(2);
        root.leftTreeNode = new SerializeAndDeserializeBinarySearchTree.BinarySearchTreeNode(1);
        root.rightTreeNode = new SerializeAndDeserializeBinarySearchTree.BinarySearchTreeNode(3);
    }

    @Test
    void testSerialize() {
        final String result = serializeAndDeserializeBinarySearchTreeUnderTest.serialize(root);
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testDeserialize() {
        // Setup
        // Run the test
        final SerializeAndDeserializeBinarySearchTree.BinarySearchTreeNode result = serializeAndDeserializeBinarySearchTreeUnderTest.deserialize(
                "2,1,NULL,NULL,3,NULL,NULL");
        System.out.println(result);
        // Verify the results
    }
}
