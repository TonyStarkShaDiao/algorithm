package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 用前序遍历和中序遍历构造二叉树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/29
 */
public class ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] 前序遍历数组, int 前序遍历数组起始位置下标, int 前序遍历结束位置数组下标, int[] 中序遍历数组, int 中序遍历数组起始位置下标, int 中序遍历结束位置下标) {
        // 前序遍历数组 为空，直接返回 null
        if (前序遍历数组起始位置下标 == 前序遍历结束位置数组下标) {
            return null;
        }
        int 当前根节点的值 = 前序遍历数组[前序遍历数组起始位置下标];
        TreeNode 当前根节点 = new TreeNode(当前根节点的值);
        //在中序遍历中找到根节点的位置
        int 当前根节点在中序遍历数组位置的下标 = 0;
        for (int 当前中序遍历数组根据指定起始和结束位置的数组的下标 = 中序遍历数组起始位置下标; 当前中序遍历数组根据指定起始和结束位置的数组的下标 < 中序遍历结束位置下标; 当前中序遍历数组根据指定起始和结束位置的数组的下标++) {
            if (当前根节点的值 == 中序遍历数组[当前中序遍历数组根据指定起始和结束位置的数组的下标]) {
                当前根节点在中序遍历数组位置的下标 = 当前中序遍历数组根据指定起始和结束位置的数组的下标;
                break;
            }
        }
        int 中序遍历数组起始位置到根节点的数量 = 当前根节点在中序遍历数组位置的下标 - 中序遍历数组起始位置下标;
        //递归的构造左子树                                                          12345
//
        当前根节点.leftTreeNode = buildTreeHelper(前序遍历数组, 前序遍历数组起始位置下标 + 1, 前序遍历数组起始位置下标 + 中序遍历数组起始位置到根节点的数量 + 1, 中序遍历数组, 中序遍历数组起始位置下标, 当前根节点在中序遍历数组位置的下标);
        //递归的构造右子树
        当前根节点.rightTreeNode = buildTreeHelper(前序遍历数组, 前序遍历数组起始位置下标 + 中序遍历数组起始位置到根节点的数量 + 1, 前序遍历结束位置数组下标, 中序遍历数组, 当前根节点在中序遍历数组位置的下标 + 1, 中序遍历结束位置下标);
        return 当前根节点;
    }

    public TreeNode mySelf_RecursionBuildTree(int[] preorderTraversalArray, int[] middleOrderTraversalArray) {
        return mySelf_RecursionBuildTree(preorderTraversalArray, 0, preorderTraversalArray.length, middleOrderTraversalArray, 0, middleOrderTraversalArray.length);
    }

    public TreeNode mySelf_RecursionBuildTree(int[] preorderTraversalArray, int preorderTraversalArrayStartIndex, int preorderTraversalArrayEndIndex
            , int[] middleOrderTraversalArray, int middleOrderTraversalStartIndex, int middleOrderTraversalEndStartIndex) {
        if (preorderTraversalArrayStartIndex == preorderTraversalArrayEndIndex) {
            return null;
        }
        int CurrentPreorderTraversalArrayRootNode = preorderTraversalArray[preorderTraversalArrayStartIndex];
        TreeNode rootNode = new TreeNode(CurrentPreorderTraversalArrayRootNode);
        int currentMiddleOrderTraversalRootNodeIndex = 0;
        for (int currentMiddleOrderTraversalAppointRangeIndex = middleOrderTraversalStartIndex; currentMiddleOrderTraversalAppointRangeIndex < middleOrderTraversalEndStartIndex; currentMiddleOrderTraversalAppointRangeIndex++) {
            if (CurrentPreorderTraversalArrayRootNode == middleOrderTraversalArray[currentMiddleOrderTraversalAppointRangeIndex]) {
                currentMiddleOrderTraversalRootNodeIndex = currentMiddleOrderTraversalAppointRangeIndex;
                break;
            }
        }
        int currentMiddleOrderTraversalStartOfCenterNumber = currentMiddleOrderTraversalRootNodeIndex - middleOrderTraversalStartIndex;
        rootNode.leftTreeNode = mySelf_RecursionBuildTree(preorderTraversalArray,
                preorderTraversalArrayStartIndex + 1, preorderTraversalArrayStartIndex + currentMiddleOrderTraversalStartOfCenterNumber + 1, middleOrderTraversalArray, preorderTraversalArrayStartIndex, currentMiddleOrderTraversalRootNodeIndex);
        rootNode.rightTreeNode = mySelf_RecursionBuildTree(preorderTraversalArray,
                preorderTraversalArrayStartIndex + currentMiddleOrderTraversalStartOfCenterNumber + 1, preorderTraversalArrayEndIndex, middleOrderTraversalArray, currentMiddleOrderTraversalRootNodeIndex + 1, middleOrderTraversalEndStartIndex);
        return rootNode;
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.leftTreeNode = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.rightTreeNode = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    private Map<Integer, Integer> middleOrderTraversalElementIndexMap;

    public TreeNode mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(int[] preorderTraversalArray, int[] middleOrderTraversalArray) {
        int middleOrderTraversalArrayLength = middleOrderTraversalArray.length;
        middleOrderTraversalElementIndexMap = new HashMap<Integer, Integer>();
        for (int middleOrderTraversalArrayIndex = 0; middleOrderTraversalArrayIndex < middleOrderTraversalArrayLength; middleOrderTraversalArrayIndex++) {
            middleOrderTraversalElementIndexMap.put(middleOrderTraversalArray[middleOrderTraversalArrayIndex], middleOrderTraversalArrayIndex);
        }

        TreeNode binaryTree = this.mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(preorderTraversalArray, middleOrderTraversalArray, 0, preorderTraversalArray.length - 1, 0, middleOrderTraversalArrayLength - 1);
        return binaryTree;
    }

    TreeNode mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(int[] preorderTraversalArray, int[] middleOrderTraversalArray, int preorderTraversalArrayStartIndex, int preorderTraversalArrayEndIndex, int middleOrderTraversalArrayStartIndex, int middleOrderTraversalArrayEndIndex) {
        if (preorderTraversalArrayStartIndex > preorderTraversalArrayEndIndex) {
            return null;
        }
        int currentPreorderTraversalArrayRootIndex = preorderTraversalArrayStartIndex;
        int currentRootInMiddleOrderArrayIndex = middleOrderTraversalElementIndexMap.get(preorderTraversalArray[currentPreorderTraversalArrayRootIndex]);
        TreeNode rootTreeNode = new TreeNode(preorderTraversalArray[currentPreorderTraversalArrayRootIndex]);
        int middleOrderTraversalArrayInLeftTreeNodeNumber = currentRootInMiddleOrderArrayIndex - middleOrderTraversalArrayStartIndex;
        rootTreeNode.leftTreeNode = this.mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(preorderTraversalArray, middleOrderTraversalArray, preorderTraversalArrayStartIndex + 1, preorderTraversalArrayStartIndex + middleOrderTraversalArrayInLeftTreeNodeNumber, middleOrderTraversalArrayStartIndex, currentRootInMiddleOrderArrayIndex - 1);
        rootTreeNode.rightTreeNode = this.mySelf_HashConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(preorderTraversalArray, middleOrderTraversalArray, preorderTraversalArrayStartIndex + middleOrderTraversalArrayInLeftTreeNodeNumber + 1, preorderTraversalArrayEndIndex, currentRootInMiddleOrderArrayIndex + 1, middleOrderTraversalArrayEndIndex);
        return rootTreeNode;
    }

    public TreeNode mySelf_ConstructingBinaryTreeByPreorderTraversalAndMiddleOrderTraversal(int[] preorderTraversalArray, int[] middleOrderTraversalArray) {
        if (preorderTraversalArray == null || preorderTraversalArray.length == 0 || middleOrderTraversalArray == null || middleOrderTraversalArray.length == 0) {
            return null;
        }
        int preorderTraversalArrayIndex = 0, middleOrderTraversalArrayIndex = 0;
        TreeNode root = new TreeNode(preorderTraversalArray[preorderTraversalArrayIndex++]), currentTreeRoot = root;
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        treeNodeStack.push(root);
        while (preorderTraversalArrayIndex < preorderTraversalArray.length) {
            if (treeNodeStack.peek().value == middleOrderTraversalArray[middleOrderTraversalArrayIndex]) {
                while (!treeNodeStack.isEmpty() && treeNodeStack.peek().value == middleOrderTraversalArray[middleOrderTraversalArrayIndex]) {
                    currentTreeRoot = treeNodeStack.pop();
                    middleOrderTraversalArrayIndex++;
                }
                currentTreeRoot.rightTreeNode = new TreeNode(preorderTraversalArray[preorderTraversalArrayIndex++]);
                treeNodeStack.push(root.rightTreeNode);
                currentTreeRoot = currentTreeRoot.rightTreeNode;
            } else {
                currentTreeRoot.leftTreeNode = new TreeNode(preorderTraversalArray[preorderTraversalArrayIndex++]);
                treeNodeStack.push(currentTreeRoot.leftTreeNode);
                currentTreeRoot = currentTreeRoot.leftTreeNode;
            }
        }
        return root;
    }


}
