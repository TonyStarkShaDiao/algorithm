package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 树最大深度
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/03
 */
public class TreeMaximumDepth {
    public static class TreeNode {
        public int value;
        public TreeNode leftTreeNode;
        public TreeNode rightTreeNode;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.value = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.leftTreeNode = left;
            this.rightTreeNode = right;
        }
    }

    public Integer mySelf_BreathFirstSearchTreeNodeDepth(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        int depth =0;
        Deque<TreeNode> TemporaryTreeNodeDeque =new LinkedList<>();
        TemporaryTreeNodeDeque.add(treeNode);
        while (!TemporaryTreeNodeDeque.isEmpty()) {
            for (int i = 0; i < TemporaryTreeNodeDeque.size(); i++) {
                TreeNode current = TemporaryTreeNodeDeque.pop();
                if (current.leftTreeNode!=null){
                    TemporaryTreeNodeDeque.add(current.leftTreeNode);
                }
                if (current.rightTreeNode!=null){
                    TemporaryTreeNodeDeque.add(current.rightTreeNode);
                }
            }
            depth+=1;
        }
        return depth;
    }

    public Integer mySelf_DepthFirstSearchTreeNodeDepth(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        Integer leftTreeNodeDepth = mySelf_DepthFirstSearchTreeNodeDepth(treeNode.leftTreeNode);
        Integer rightTreeNodeDepth = mySelf_DepthFirstSearchTreeNodeDepth(treeNode.rightTreeNode);
        return Math.max(leftTreeNodeDepth,rightTreeNodeDepth)+1;
    }
}
