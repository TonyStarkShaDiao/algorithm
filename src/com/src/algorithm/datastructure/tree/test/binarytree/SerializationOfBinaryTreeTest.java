package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.SerializationOfBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//
class SerializationOfBinaryTreeTest {

    private SerializationOfBinaryTree serializationOfBinaryTreeUnderTest;
    private SerializationOfBinaryTree.TreeNode root;
    private String expectSerialCharacterString;

    @BeforeEach
    void setUp() {
        serializationOfBinaryTreeUnderTest = new SerializationOfBinaryTree();
        root = new SerializationOfBinaryTree.TreeNode(1);
        root.leftTreeNode = new SerializationOfBinaryTree.TreeNode(2);
        root.rightTreeNode = new SerializationOfBinaryTree.TreeNode(3);
        root.leftTreeNode.leftTreeNode = new SerializationOfBinaryTree.TreeNode(4);
        root.leftTreeNode.rightTreeNode = new SerializationOfBinaryTree.TreeNode(5);
        root.rightTreeNode.rightTreeNode = new SerializationOfBinaryTree.TreeNode(6);
        expectSerialCharacterString = "[1,2,3,4,5,null,6,null,null,null,null,null,null]";
    }

    @Test
    void testSerialize() {

        // Run the test
        final String result = serializationOfBinaryTreeUnderTest.serialize(root);

        // Verify the results
        assertThat(result).isEqualTo(expectSerialCharacterString);
    }

    @Test
    void testDeserialize() {
        SerializationOfBinaryTree.TreeNode deserialize = serializationOfBinaryTreeUnderTest.deserialize("[1,2,3,null,null,4,5,6,7]");
        System.out.println(deserialize);
    }
}
