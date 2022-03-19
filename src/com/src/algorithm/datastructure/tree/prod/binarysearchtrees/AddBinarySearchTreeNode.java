package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 添加二叉搜索树节点
 * 添加二叉搜索树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/09
 */
public class AddBinarySearchTreeNode {
    public Integer[] binarySearchTreeNodeConvertArray(BinarySearchTreeNode addBinarySearchTreeNodeResult) {
        if (addBinarySearchTreeNodeResult==null){
            return null;
        }
        Deque<BinarySearchTreeNode> binarySearchTreeNodeDeque =new ArrayDeque<>();
        binarySearchTreeNodeDeque.add(addBinarySearchTreeNodeResult);
        List<Integer> binarySearchTreeNodeElementCollect  =new ArrayList<>();
        while (!binarySearchTreeNodeDeque.isEmpty()) {
            BinarySearchTreeNode current = binarySearchTreeNodeDeque.pop();
            binarySearchTreeNodeElementCollect.add(current.value);
            if (current.leftTreeNode!=null){
                binarySearchTreeNodeDeque.add(current.leftTreeNode);
            }
            if (current.rightTreeNode!=null){
                binarySearchTreeNodeDeque.add(current.rightTreeNode);
            }
        }
    return binarySearchTreeNodeElementCollect.toArray(new Integer[binarySearchTreeNodeElementCollect.size()]);
    }

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
     * 我自己遍历二叉搜索树添加节点
     *
     * @param addElement               添加元素
     * @param binarySearchTreeRootNode 二进制搜索树根节点
     * @return {@link BinarySearchTreeNode}
     */
    public BinarySearchTreeNode mySelf_TraverseAddBinarySearchTreeNode(BinarySearchTreeNode binarySearchTreeRootNode, int addElement) {
        if (binarySearchTreeRootNode == null) {
            return new BinarySearchTreeNode(addElement);
        }
        BinarySearchTreeNode temporaryBSTTreeNode = binarySearchTreeRootNode;
        while (temporaryBSTTreeNode != null) {
            if (addElement > temporaryBSTTreeNode.value) {
                if (temporaryBSTTreeNode.rightTreeNode == null) {
                    temporaryBSTTreeNode.rightTreeNode = new BinarySearchTreeNode(addElement);
                    break;
                } else {
                    temporaryBSTTreeNode = temporaryBSTTreeNode.rightTreeNode;
                }
            }
            if (addElement < temporaryBSTTreeNode.value) {
                if (temporaryBSTTreeNode.leftTreeNode == null) {
                    temporaryBSTTreeNode.leftTreeNode = new BinarySearchTreeNode(addElement);
                    break;
                } else {
                    temporaryBSTTreeNode = temporaryBSTTreeNode.leftTreeNode;
                }
            }
        }
        return binarySearchTreeRootNode;
    }

    public BinarySearchTreeNode mySelf_SimpleTraverseAddBinarySearchTreeNode(BinarySearchTreeNode binarySearchTreeRootNode, int addElement) {
        if (binarySearchTreeRootNode == null) {
            return new BinarySearchTreeNode(addElement);
        }
        BinarySearchTreeNode temporaryBSTTreeNode = binarySearchTreeRootNode;
        while (temporaryBSTTreeNode != null) {
            if (temporaryBSTTreeNode.leftTreeNode == null && addElement < temporaryBSTTreeNode.value) {
                temporaryBSTTreeNode.leftTreeNode = new BinarySearchTreeNode(addElement);
            }
            if (temporaryBSTTreeNode.rightTreeNode == null && addElement > temporaryBSTTreeNode.value) {
                temporaryBSTTreeNode.rightTreeNode = new BinarySearchTreeNode(addElement);
            }
            temporaryBSTTreeNode = addElement < temporaryBSTTreeNode.value ? temporaryBSTTreeNode.leftTreeNode : temporaryBSTTreeNode.rightTreeNode;
        }
        return binarySearchTreeRootNode;
    }

    public BinarySearchTreeNode mySelf_LastTreeNodeBinarySearchTreeNode(BinarySearchTreeNode binarySearchTreeRootNode, int addElement) {
        if (binarySearchTreeRootNode == null) {
            return new BinarySearchTreeNode(addElement);
        }
        BinarySearchTreeNode lastBSTTreeNode = binarySearchTreeRootNode;
        while ((lastBSTTreeNode.leftTreeNode != null && addElement < lastBSTTreeNode.value) ||
                (lastBSTTreeNode.rightTreeNode != null && addElement > lastBSTTreeNode.value)) {
            lastBSTTreeNode = addElement > lastBSTTreeNode.value ? lastBSTTreeNode.rightTreeNode : lastBSTTreeNode.leftTreeNode;
        }
        if (addElement > lastBSTTreeNode.value) {
            lastBSTTreeNode.rightTreeNode = new BinarySearchTreeNode(addElement);
        } else {
            lastBSTTreeNode.leftTreeNode = new BinarySearchTreeNode(addElement);

        }
        return binarySearchTreeRootNode;
    }

    public BinarySearchTreeNode mySelf_RecursiveTreeNodeBinarySearchTreeNode(BinarySearchTreeNode binarySearchTreeRootNode, int addElement) {
        if (binarySearchTreeRootNode == null) {
            return new BinarySearchTreeNode(addElement);
        }
        if (addElement < binarySearchTreeRootNode.value) {
            binarySearchTreeRootNode.leftTreeNode = mySelf_RecursiveTreeNodeBinarySearchTreeNode(binarySearchTreeRootNode.leftTreeNode, addElement);
        } else {
            binarySearchTreeRootNode.rightTreeNode = mySelf_RecursiveTreeNodeBinarySearchTreeNode(binarySearchTreeRootNode.rightTreeNode, addElement);
        }
        return binarySearchTreeRootNode;
    }
}
