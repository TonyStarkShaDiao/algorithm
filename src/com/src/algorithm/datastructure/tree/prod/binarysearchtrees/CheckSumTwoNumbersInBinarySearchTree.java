package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.*;

/**
 * 二叉搜索树两数之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/17
 */
public class CheckSumTwoNumbersInBinarySearchTree {
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

    /**
     * 我自己深度优先搜索和双指针校验两数之和在二叉搜索树
     *
     * @param binarySearchTreeNode 二叉搜索树节点
     * @param checkSumValue        校验和值
     * @return {@code Boolean}
     */
    public Boolean mySelf_depthFirstSearchAndDoublePointerCheckSumTwoNumbersInBinarySearchTree(BinarySearchTreeNode binarySearchTreeNode, int checkSumValue) {
       List<Integer> binarySearchTeeElement = inSequenceTraversal(binarySearchTreeNode);
       int firstElementIndex = 0 ;
       int lastFirstElementIndex=binarySearchTeeElement.size()-1;
        while (firstElementIndex<lastFirstElementIndex) {
            Integer firstElement = binarySearchTeeElement.get(firstElementIndex);
            Integer lastFirstElement = binarySearchTeeElement.get(lastFirstElementIndex);
            int currentElementSum = firstElement + lastFirstElement;
            if (currentElementSum==checkSumValue){
                return true;
            }
            if (currentElementSum>checkSumValue){
                lastFirstElementIndex--;
            }else {
                firstElementIndex++;
            }
        }
        return false;
    }

    private List<Integer> inSequenceTraversal(BinarySearchTreeNode binarySearchTreeNode) {
      Stack<BinarySearchTreeNode> temporaryBinarySearchTreeNodeStack =new Stack<>();
        List<Integer> binarySearchTeeElement =new ArrayList<>();
        while (!temporaryBinarySearchTreeNodeStack.isEmpty() || binarySearchTreeNode != null) {
            while (binarySearchTreeNode != null) {
                temporaryBinarySearchTreeNodeStack.add(binarySearchTreeNode);
                binarySearchTreeNode=binarySearchTreeNode.leftTreeNode;
            }
            BinarySearchTreeNode currentBinarySearchTreeNode = temporaryBinarySearchTreeNodeStack.pop();
            binarySearchTeeElement.add(currentBinarySearchTreeNode.value);
            binarySearchTreeNode=currentBinarySearchTreeNode.rightTreeNode;
        }
        return binarySearchTeeElement;
    }

    public Boolean mySelf_SimpleCheckSumTwoNumbersInBinarySearchTree(BinarySearchTreeNode binarySearchTreeNode, int checkSumValue) {
        Set<Integer> temporaryBinarySearchTreeNodeElementContainer = new HashSet<>();
        Deque<BinarySearchTreeNode> binarySearchTreeNodeDeque =new ArrayDeque<>();
        binarySearchTreeNodeDeque.add(binarySearchTreeNode);
        while (!binarySearchTreeNodeDeque.isEmpty()) {
            BinarySearchTreeNode currentBinarySearchTreeNode = binarySearchTreeNodeDeque.pop();
            if (temporaryBinarySearchTreeNodeElementContainer.contains(checkSumValue-currentBinarySearchTreeNode.value)){
                return true;
            }
            temporaryBinarySearchTreeNodeElementContainer.add(currentBinarySearchTreeNode.value);
            if (currentBinarySearchTreeNode.leftTreeNode!=null) {
                binarySearchTreeNodeDeque.add(currentBinarySearchTreeNode.leftTreeNode);
            }
            if (currentBinarySearchTreeNode.rightTreeNode!=null) {
                binarySearchTreeNodeDeque.add(currentBinarySearchTreeNode.rightTreeNode);
            }
        }
        return false;
    }
    /**
     * 我自我广度优先搜索二叉搜索树校验和两个数字
     *
     * @param binarySearchTreeNode 二叉搜索树节点
     * @param checkSumValue        校验和值
     * @return {@code Boolean}
     */
    public Boolean mySelf_BreadthFirstSearchCheckSumTwoNumbersInBinarySearchTree(BinarySearchTreeNode binarySearchTreeNode, int checkSumValue) {
        List<Integer> binarySearchTreeNodeElementCollect = BreadthFirstSearch(binarySearchTreeNode);
        Set<Integer> temporaryBinarySearchTreeNodeElementContainer = new HashSet<>();
        for (int binarySearchTreeNodeElementCollectIndex = 0; binarySearchTreeNodeElementCollectIndex <binarySearchTreeNodeElementCollect.size(); binarySearchTreeNodeElementCollectIndex++) {
            if (temporaryBinarySearchTreeNodeElementContainer.contains(checkSumValue - binarySearchTreeNodeElementCollect.get(binarySearchTreeNodeElementCollectIndex))) {
                return true;
            }
            temporaryBinarySearchTreeNodeElementContainer.add(binarySearchTreeNodeElementCollect.get(binarySearchTreeNodeElementCollectIndex));
        }
        return false;
    }

    private List<Integer> BreadthFirstSearch(BinarySearchTreeNode binarySearchTreeNode) {
        List<Integer> binarySearchElementCollect = new ArrayList<>();
        Deque<BinarySearchTreeNode> temporaryBinarySearchNodeDeque = new ArrayDeque<>();
        temporaryBinarySearchNodeDeque.push(binarySearchTreeNode);
        while (!temporaryBinarySearchNodeDeque.isEmpty()) {
            BinarySearchTreeNode currentBinarySearchNode = temporaryBinarySearchNodeDeque.pop();
            binarySearchElementCollect.add(currentBinarySearchNode.value);
            if (currentBinarySearchNode.leftTreeNode != null) {
                temporaryBinarySearchNodeDeque.push(currentBinarySearchNode.leftTreeNode);
            }
            if (currentBinarySearchNode.rightTreeNode != null) {
                temporaryBinarySearchNodeDeque.push(currentBinarySearchNode.rightTreeNode);
            }
        }
        return binarySearchElementCollect;
    }
}
