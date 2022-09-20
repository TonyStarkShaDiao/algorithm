package com.src.algorithm.datastructure.nodes.prod;

/**
 * 为每个节点填充下一个右节点指针
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/29
 */
public class PopulateNextRightNodePointerForEachNode {
    public static class Node {
        public int value;
        /**
         * 左树节点点
         */
        public Node leftTreeNodePoint;
        /**
         * 右树节点点
         */
        public Node rightTreeNodePoint;
        /**
         * 下一个树节点
         */
        public Node nextTreeNodePoint;

        public Node() {
        }

        public Node(int _val) {
            value = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            value = _val;
            leftTreeNodePoint = _left;
            rightTreeNodePoint = _right;
            nextTreeNodePoint = _next;
        }
    }

    /**
     * 已使用节点点为每个节点填充下一个右节点指针
     *
     * @param nodeRoot 根
     * @return {@code Node}
     */
    public Node usedAlreadyExistsNodePointPopulateNextRightNodePointerForEachNode(Node nodeRoot) {
        if (nodeRoot == null) {
            return null;
        }
        Node currentMostLeftNodePoint = nodeRoot;
        while (currentMostLeftNodePoint.leftTreeNodePoint != null) {
            Node currentNodePoint = currentMostLeftNodePoint;
            while (currentNodePoint != null) {
                currentNodePoint.leftTreeNodePoint.nextTreeNodePoint = currentNodePoint.rightTreeNodePoint;
                if (currentNodePoint.nextTreeNodePoint != null) {
                    currentNodePoint.rightTreeNodePoint.nextTreeNodePoint = currentNodePoint.nextTreeNodePoint.leftTreeNodePoint;
                }
                currentNodePoint = currentNodePoint.nextTreeNodePoint;
            }

            currentMostLeftNodePoint = currentMostLeftNodePoint.leftTreeNodePoint;
        }
        return nodeRoot;
    }

}
