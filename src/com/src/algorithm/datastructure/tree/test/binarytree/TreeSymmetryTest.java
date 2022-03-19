package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeSymmetry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeSymmetryTest {

    public static final String JUDGE_ERROR_MESSAGE = "结果为对称二叉树";
    TreeSymmetry.TreeNode treeNodeRoot;
    TreeSymmetry treeSymmetry;
    @BeforeEach
    void setUp() {
        treeSymmetry= new TreeSymmetry();
        treeNodeRoot =new TreeSymmetry.TreeNode();
        treeNodeRoot.leftTreeNode=new TreeSymmetry.TreeNode(1);
        treeNodeRoot.rightTreeNode=new TreeSymmetry.TreeNode(1);
        treeNodeRoot.leftTreeNode.leftTreeNode =new TreeSymmetry.TreeNode(2);
        treeNodeRoot.leftTreeNode.rightTreeNode =new TreeSymmetry.TreeNode(3);
        treeNodeRoot.rightTreeNode.leftTreeNode =new TreeSymmetry.TreeNode(3);
        treeNodeRoot.rightTreeNode.rightTreeNode =new TreeSymmetry.TreeNode(2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_DequeDoublePointerSymmetry() {
        Boolean is_Symmetry = treeSymmetry.mySelf_DequeDoublePointerSymmetry(treeNodeRoot);
        judgeMatchingResult(is_Symmetry);
    }

    @Test
    void mySelf_RecursiveDoublePointerSymmetry() {
        Boolean is_Symmetry = treeSymmetry.mySelf_RecursiveDoublePointerSymmetry(treeNodeRoot);
        judgeMatchingResult(is_Symmetry);
    }

    private void judgeMatchingResult(Boolean is_Symmetry) {
        assertTrue(is_Symmetry, JUDGE_ERROR_MESSAGE);
    }
}