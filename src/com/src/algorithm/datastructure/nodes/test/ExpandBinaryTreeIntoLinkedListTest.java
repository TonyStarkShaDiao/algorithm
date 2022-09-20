package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.ExpandBinaryTreeIntoLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpandBinaryTreeIntoLinkedListTest {

    private ExpandBinaryTreeIntoLinkedList expandBinaryTreeIntoLinkedListUnderTest;
    private ExpandBinaryTreeIntoLinkedList.TreeNode root;
    private ExpandBinaryTreeIntoLinkedList.TreeNode ExpectedLinkedTreeNode;

    private

    @BeforeEach
    void setUp() {
        expandBinaryTreeIntoLinkedListUnderTest = new ExpandBinaryTreeIntoLinkedList();
        root = new ExpandBinaryTreeIntoLinkedList.TreeNode(1);
        root.left = new ExpandBinaryTreeIntoLinkedList.TreeNode(2);
        root.right = new ExpandBinaryTreeIntoLinkedList.TreeNode(5);
        root.left.left = new ExpandBinaryTreeIntoLinkedList.TreeNode(3);
        root.left.right = new ExpandBinaryTreeIntoLinkedList.TreeNode(4);
        root.right.right = new ExpandBinaryTreeIntoLinkedList.TreeNode(6);
        ExpectedLinkedTreeNode = root;
    }

    @Test
    void testMySelf_preorderTraversal() {
        expandBinaryTreeIntoLinkedListUnderTest.mySelf_middleOrderTraversal(
                root);
        assertThat(root).isEqualTo(ExpectedLinkedTreeNode);

    }

    @Test
    void flatten() {
        expandBinaryTreeIntoLinkedListUnderTest.flatten(root);
    }
}
