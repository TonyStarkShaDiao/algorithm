package com.src.algorithm.datastructure.tree.test.binarytree;

import com.src.algorithm.datastructure.tree.prod.binarytree.TreeMaximumDepth;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeMaximumDepthTest {
    public static final String ERROR_MESSAGE = "最深树层级为3级,结果不正确为:";
    TreeMaximumDepth treeMaximumDepth;
TreeMaximumDepth.TreeNode treeNode;
    @BeforeEach
    void setUp() {
        treeMaximumDepth =new TreeMaximumDepth();
        treeNode =new TreeMaximumDepth.TreeNode();
        treeNode.leftTreeNode=new TreeMaximumDepth.TreeNode();
        treeNode.rightTreeNode=new TreeMaximumDepth.TreeNode();
        treeNode.rightTreeNode.leftTreeNode=new TreeMaximumDepth.TreeNode();
        treeNode.rightTreeNode.rightTreeNode=new TreeMaximumDepth.TreeNode();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_DepthFirstSearchTreeNodeDepth() {
        Integer treeNodeDepth = treeMaximumDepth.mySelf_BreathFirstSearchTreeNodeDepth(treeNode);
        checkTestResult(treeNodeDepth);
    }

    private void checkTestResult(Integer treeNodeDepth) {
        assertEquals(3, treeNodeDepth, ERROR_MESSAGE + treeNodeDepth);
    }

    @Test
    void mySelf_BreathFirstSearchTreeNodeDepth() {
        Integer treeNodeDepth = treeMaximumDepth.mySelf_DepthFirstSearchTreeNodeDepth(treeNode);
        checkTestResult(treeNodeDepth);
    }
}