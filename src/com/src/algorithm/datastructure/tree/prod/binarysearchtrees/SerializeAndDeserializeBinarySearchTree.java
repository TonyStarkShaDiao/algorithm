package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.*;

/**
 * 序列化和反序列化二进制搜索树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/11
 */
public class SerializeAndDeserializeBinarySearchTree {
    public static class BinarySearchTreeNode {
        public int value;
        public BinarySearchTreeNode leftTreeNode;
        public BinarySearchTreeNode rightTreeNode;

        public BinarySearchTreeNode() {
        }

        public BinarySearchTreeNode(int val) {
            this.value = val;
        }

        public BinarySearchTreeNode(int val, BinarySearchTreeNode left, BinarySearchTreeNode right) {
            this.value = val;
            this.leftTreeNode = left;
            this.rightTreeNode = right;
        }

    }

    public String serialize(BinarySearchTreeNode root) {
        BinarySearchTreeNode currentTreeNode = root;
        StringBuilder treeNodeCharacterString = new StringBuilder();
        Stack<BinarySearchTreeNode> tempStack = new Stack<>();
        tempStack.push(currentTreeNode);
        while (!tempStack.isEmpty()) {
            BinarySearchTreeNode currentPollTreeNode = tempStack.pop();
            if (currentPollTreeNode != null) {
                treeNodeCharacterString.append(currentPollTreeNode.value).append(",");
                tempStack.push(currentPollTreeNode.rightTreeNode);
                tempStack.push(currentPollTreeNode.leftTreeNode);
            } else {
                treeNodeCharacterString.append("NULL,");
            }
        }
        return treeNodeCharacterString.substring(0, treeNodeCharacterString.length() - 1);
    }

    public BinarySearchTreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> treeNodeElementCollect = new LinkedList<>(Arrays.asList(split));
        return preDeserialize(treeNodeElementCollect);
    }

    private BinarySearchTreeNode preDeserialize(List<String> treeNodeElementCollect) {
        if (treeNodeElementCollect.get(0).equals("NULL")) {
            treeNodeElementCollect.remove(0);
            return null;
        }
        BinarySearchTreeNode root = new BinarySearchTreeNode(Integer.parseInt(treeNodeElementCollect.get(0)));
        treeNodeElementCollect.remove(0);
        root.leftTreeNode = preDeserialize(treeNodeElementCollect);
        root.rightTreeNode = preDeserialize(treeNodeElementCollect);
        return root;
    }
}
