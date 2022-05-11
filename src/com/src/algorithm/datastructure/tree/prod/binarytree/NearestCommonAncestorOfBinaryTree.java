package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.*;

/**
 * 二叉树最近共同祖先
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/06
 */
public class NearestCommonAncestorOfBinaryTree {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TreeNode leftTreeNode = (TreeNode) o;
            TreeNode rightTreeNode = (TreeNode) o;
            TreeNode thisLeftTreeNode = this;
            TreeNode thisRightTreeNode = this;
//            this.treeNodeToArray
            while (leftTreeNode != null || thisLeftTreeNode != null) {
                if (leftTreeNode == null && thisLeftTreeNode != null) {
                    return false;
                }
                if (leftTreeNode != null && thisLeftTreeNode == null) {
                    return false;
                }
                if (thisLeftTreeNode.value != leftTreeNode.value) {
                    return false;
                }
                leftTreeNode = leftTreeNode.leftTreeNode;
                thisLeftTreeNode = thisLeftTreeNode.leftTreeNode;

            }
            while (rightTreeNode != null && thisRightTreeNode != null) {
                if (thisRightTreeNode.value != rightTreeNode.value) {
                    return false;
                }
                rightTreeNode = rightTreeNode.rightTreeNode;
                thisRightTreeNode = thisRightTreeNode.rightTreeNode;
            }

            return true;
        }
    }

    public TreeNode mySelf_HashIterationNearestCommonAncestorOfBinaryTree(TreeNode root, TreeNode firstTreeNode, TreeNode secondTreeNode) {
        if (root == null) {
            return root;
        }
        Map<TreeNode, TreeNode> findParentNodeByChildrenNodeMap = new HashMap<>();
        Queue<TreeNode> currentNodeParentNodeDeque = new ArrayDeque<>();
        currentNodeParentNodeDeque.add(root);
        findParentNodeByChildrenNodeMap.put(root, null);
        while (!findParentNodeByChildrenNodeMap.containsKey(firstTreeNode) || !findParentNodeByChildrenNodeMap.containsKey(secondTreeNode)) {
            TreeNode currentNode = currentNodeParentNodeDeque.poll();
            if (currentNode.leftTreeNode != null) {
                currentNodeParentNodeDeque.add(currentNode.leftTreeNode);
                findParentNodeByChildrenNodeMap.put(currentNode.leftTreeNode, currentNode);
            }
            if (currentNode.rightTreeNode != null) {
                currentNodeParentNodeDeque.add(currentNode.rightTreeNode);
                findParentNodeByChildrenNodeMap.put(currentNode.rightTreeNode, currentNode);
            }
        }
        Set<TreeNode> treeNodes = new HashSet<>();
        ;
        while (firstTreeNode != null) {
            treeNodes.add(firstTreeNode);
            firstTreeNode = findParentNodeByChildrenNodeMap.get(firstTreeNode);
        }
        while (!treeNodes.contains(secondTreeNode)) {
            secondTreeNode = findParentNodeByChildrenNodeMap.get(secondTreeNode);
        }
        return secondTreeNode;
    }

    public TreeNode mySelf_RecursionNearestCommonAncestorOfBinaryTree(TreeNode root, TreeNode firstTreeNode, TreeNode secondTreeNode) {
        if (root == null || root == firstTreeNode || root == secondTreeNode) {
            return root;
        }
        TreeNode left = mySelf_RecursionNearestCommonAncestorOfBinaryTree(root.leftTreeNode, firstTreeNode, secondTreeNode);
        TreeNode right = mySelf_RecursionNearestCommonAncestorOfBinaryTree(root.rightTreeNode, firstTreeNode, secondTreeNode);
        return left == null ? right : right == null ? left : root;
    }
}
