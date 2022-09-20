package com.src.algorithm.datastructure.tree.test.binarysearchtrees;

import com.src.algorithm.datastructure.tree.prod.binarysearchtrees.TreeNodeSuccessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
//

class TreeNodeSuccessorTest {

    private TreeNodeSuccessor treeNodeSuccessorUnderTest;
    TreeNodeSuccessor.BinarySearchTreeNode root;
    TreeNodeSuccessor.BinarySearchTreeNode targetTreeNode;
    private TreeNodeSuccessor.BinarySearchTreeNode expectSuccessorTreeNode;

    @BeforeEach
    void setUp() {
        treeNodeSuccessorUnderTest = new TreeNodeSuccessor();
        TreeNodeSuccessor.BinarySearchTreeNode binarySearchTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(12);
        root = new TreeNodeSuccessor.BinarySearchTreeNode(10);
        root.leftTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(5);
        root.rightTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(15);
        root.leftTreeNode.leftTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(2);
        root.leftTreeNode.rightTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(7);
        root.rightTreeNode.leftTreeNode = binarySearchTreeNode;
        root.rightTreeNode.rightTreeNode = new TreeNodeSuccessor.BinarySearchTreeNode(20);
        targetTreeNode = root;
        expectSuccessorTreeNode = binarySearchTreeNode;
    }

    @Test
    void testMySelf_DichotomySuccessor() {
        final TreeNodeSuccessor.BinarySearchTreeNode result = treeNodeSuccessorUnderTest.mySelf_DichotomySuccessor(root,
                targetTreeNode);
        assertThat(result).isEqualTo(expectSuccessorTreeNode);
    }

    @Test
    void testMySelf_previousTreeNodeSuccessor() {
        final TreeNodeSuccessor.BinarySearchTreeNode result = treeNodeSuccessorUnderTest.mySelf_previousTreeNodeSuccessor(
                root, targetTreeNode);
        assertThat(result).isEqualTo(expectSuccessorTreeNode);
    }

    @Test
    void testMySelf_booleanSuccessor() {
        final TreeNodeSuccessor.BinarySearchTreeNode result = treeNodeSuccessorUnderTest.mySelf_booleanSuccessor(root,
                targetTreeNode);
        assertThat(result).isEqualTo(expectSuccessorTreeNode);
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

}
