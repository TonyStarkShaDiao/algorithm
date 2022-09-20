package com.src.algorithm.datastructure.nodes.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * lur 缓存
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/19
 */
public class LRUCache {
    private Map<Integer, Node> nodeIndexAndAddressCollect;

    private int capacity;

    private DoubleLinkedNode cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoubleLinkedNode();
        nodeIndexAndAddressCollect = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeIndexAndAddressCollect.containsKey(key)) {
            return -1;
        }
        Node node = nodeIndexAndAddressCollect.get(key);
        int value = node.value;
        this.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (nodeIndexAndAddressCollect.containsKey(key)) {
            int delete = cache.delete(nodeIndexAndAddressCollect.get(key));
            nodeIndexAndAddressCollect.put(key, node);
            cache.addFirst(node);
        } else {
            if (nodeIndexAndAddressCollect.size() >= capacity) {
                int delKey = cache.deleteLast();
                nodeIndexAndAddressCollect.remove(delKey);
            }
            cache.addFirst(node);
            nodeIndexAndAddressCollect.put(key, node);
        }


    }

    public class DoubleLinkedNode {
        private Node headerNode;
        private Node tailNode;

        public DoubleLinkedNode() {
            this.headerNode = new Node(0, 0);
            this.tailNode = new Node(0, 0);
            this.headerNode.nextNode = this.tailNode;
            this.tailNode.previousNode = this.headerNode;
        }

        public void addFirst(Node addNode) {
            addNode.nextNode = this.headerNode.nextNode;
            addNode.previousNode = this.headerNode;
            this.headerNode.nextNode.previousNode = addNode;
            this.headerNode.nextNode = addNode;
        }

        public int delete(Node delNode) {
            delNode.nextNode.previousNode = delNode.previousNode;
            delNode.previousNode.nextNode = delNode.nextNode;
            return delNode.key;
        }

        public int deleteLast() {
            return delete(this.tailNode.previousNode);
        }
    }

    public class Node {
        public int key;
        public int value;
        public Node previousNode;
        public Node nextNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}