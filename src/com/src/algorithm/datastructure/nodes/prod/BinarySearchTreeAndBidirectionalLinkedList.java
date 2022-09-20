package com.src.algorithm.datastructure.nodes.prod;

import java.util.Stack;

/**
 * 二叉搜索树和双向链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/23
 */

public class BinarySearchTreeAndBidirectionalLinkedList {
    public static class Node {
        public int val;
        public Node left;//next
        public Node right;//prev

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node middleOrderTraversal(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> binarySearchTreeElementStack = new Stack<>();
        Node currentNode = root;
        Node previousNodePoint = null, headerListNodePoint = root, tailListNodePoint = null;
        while (currentNode != null || !binarySearchTreeElementStack.isEmpty()) {
            while (currentNode != null) {
                binarySearchTreeElementStack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = binarySearchTreeElementStack.pop();
            tailListNodePoint = currentNode;
            if (previousNodePoint == null) {
                headerListNodePoint = currentNode;
            } else {
                previousNodePoint.right = currentNode;
                currentNode.left = previousNodePoint;
            }
            previousNodePoint = currentNode;
            currentNode = currentNode.right;
        }
        headerListNodePoint.left = tailListNodePoint;
        tailListNodePoint.right = headerListNodePoint;
        return headerListNodePoint;
    }
}
