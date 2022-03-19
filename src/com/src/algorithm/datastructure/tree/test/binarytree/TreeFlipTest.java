package com.src.algorithm.datastructure.tree.test.binarytree;


import com.src.algorithm.datastructure.tree.prod.binarytree.TreeFlip;
import com.src.algorithm.datastructure.tree.prod.binarytree.TreeLevelTraversal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeFlipTest {

    /**
     *             //  0
     *             //1   3
     *           //2  3 1  5
     *   flip   >>>>>>    //  0
     *       >>>>>>>  //3   1
     *        >>>>> //5  1 3  2
     * 翻转错误消息
     */
    public static final String FLIP_ERROR_MESSAGE = "翻转二叉树结果错误,正确结果为:";
    TreeFlip treeFlip;
    TreeFlip.TreeNode treeNodeRoot;
    TreeLevelTraversal treeLevelTraversal;
    private Integer[] flipSuccessArray;

    @BeforeEach
    void setUp() {
        flipSuccessArray = new Integer[]{0, 3, 1, 5, 1, 3, 2};
        treeLevelTraversal =new TreeLevelTraversal();
        treeFlip =new TreeFlip();
        treeNodeRoot =new TreeFlip.TreeNode();
        treeNodeRoot.leftTreeNode=new TreeFlip.TreeNode(1);
        treeNodeRoot.rightTreeNode=new TreeFlip.TreeNode(3);
        treeNodeRoot.leftTreeNode.leftTreeNode =new TreeFlip.TreeNode(2);
        treeNodeRoot.leftTreeNode.rightTreeNode =new TreeFlip.TreeNode(3);
        treeNodeRoot.rightTreeNode.leftTreeNode =new TreeFlip.TreeNode(1);
        treeNodeRoot.rightTreeNode.rightTreeNode =new TreeFlip.TreeNode(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_BreadthFirstTraversalTreeFlip() {
        TreeFlip.TreeNode treeNode = treeFlip.mySelf_BreadthFirstTraversalTreeFlip(treeNodeRoot);
        judgeFlipResult(treeNode);
    }

    private void judgeFlipResult(TreeFlip.TreeNode treeNode) {
        Integer[] judgeFlipArray = treeFlip.myself_BreadthFirstBinaryTreeConvertArrays(treeNode);
        Assertions.assertArrayEquals(judgeFlipArray, flipSuccessArray, FLIP_ERROR_MESSAGE+judgeFlipArray.toString());
    }

    @Test
    void mySelf_recursiveTreeFlip() {
        TreeFlip.TreeNode treeNode = treeFlip.mySelf_RecursiveTreeFlip(treeNodeRoot);
        judgeFlipResult(treeNode);
    }
}