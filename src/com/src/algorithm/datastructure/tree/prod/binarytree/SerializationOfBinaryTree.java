package com.src.algorithm.datastructure.tree.prod.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/08
 */
public class SerializationOfBinaryTree {
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

    public String serialize(TreeNode root) {
        StringBuilder binaryTreeSerializeCharacterString = new StringBuilder("[");
        Queue<TreeNode> temporaryTreeNodeDeque = new LinkedList<>();
        temporaryTreeNodeDeque.add(root);
        while (!temporaryTreeNodeDeque.isEmpty()) {
            TreeNode currentTreeNode = temporaryTreeNodeDeque.remove();
            if (currentTreeNode == null) {
                binaryTreeSerializeCharacterString.append("null,");
            } else {
                binaryTreeSerializeCharacterString.append(currentTreeNode.value).append(",");
                temporaryTreeNodeDeque.add(currentTreeNode.leftTreeNode);
                temporaryTreeNodeDeque.add(currentTreeNode.rightTreeNode);
            }
        }
        binaryTreeSerializeCharacterString.deleteCharAt(binaryTreeSerializeCharacterString.length() - 1);
        binaryTreeSerializeCharacterString.append("]");

        return binaryTreeSerializeCharacterString.toString();
    }

    public TreeNode deserialize(String data) {
        String[] treeNodeElementArray = data.substring(1, data.length() - 1).split(",");
        TreeNode root = this.getNode(treeNodeElementArray[0]);
        Queue<TreeNode> temporaryTreeNodeDeque = new LinkedList<>();
        TreeNode currentTreeNodeParent = root;
        Boolean isLeftTreeNode = true;
        for (int treeNodeElementArrayIndex = 1; treeNodeElementArrayIndex < treeNodeElementArray.length; treeNodeElementArrayIndex++) {
            TreeNode currentTreeNode = this.getNode(treeNodeElementArray[treeNodeElementArrayIndex]);
            if (isLeftTreeNode) {
                currentTreeNodeParent.leftTreeNode = currentTreeNode;
            } else {
                currentTreeNodeParent.rightTreeNode = currentTreeNode;
            }
            if (currentTreeNode != null) {
                temporaryTreeNodeDeque.add(currentTreeNode);
            }
            isLeftTreeNode = !isLeftTreeNode;
            if (isLeftTreeNode) {
                currentTreeNodeParent = temporaryTreeNodeDeque.poll();
            }
        }
        return root;
    }

    public TreeNode noAdditionalSpaceRequiredDeserialize(String data) {
        String[] treeNodeElementArray = data.substring(1, data.length() - 1).split(",");
        TreeNode root = this.getNode(treeNodeElementArray[0]);
        Queue<TreeNode> temporaryTreeNodeDeque = new LinkedList<>();
        TreeNode currentTreeNodeParent = root;
        Boolean isLeftTreeNode = true;
        for (int treeNodeElementArrayIndex = 1; treeNodeElementArrayIndex < treeNodeElementArray.length; treeNodeElementArrayIndex++) {
            TreeNode currentTreeNode = this.getNode(treeNodeElementArray[treeNodeElementArrayIndex]);
            if (currentTreeNode == null) {
                isLeftTreeNode = !isLeftTreeNode;
                continue;
            }
            if (isLeftTreeNode) {
                currentTreeNodeParent.leftTreeNode = currentTreeNode;
            } else {
                currentTreeNodeParent.rightTreeNode = currentTreeNode;
            }
            isLeftTreeNode = !isLeftTreeNode;
            if (isLeftTreeNode) {
                currentTreeNodeParent = currentTreeNode;
            }
        }
        return root;
    }

    private TreeNode getNode(String treeNodeElement) {
        if (treeNodeElement.equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(treeNodeElement));
        return treeNode;
    }
}
