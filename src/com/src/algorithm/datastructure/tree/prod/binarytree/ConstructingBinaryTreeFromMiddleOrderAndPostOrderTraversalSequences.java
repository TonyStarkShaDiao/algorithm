package com.src.algorithm.datastructure.tree.prod.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 由中、后序遍历序列构造二叉树
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/24
 */
public class ConstructingBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            //后序遍历 该节点是栈顶元素的左节点或者右节点，若有右节点则一定是右节点
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            //此时的栈顶元素的值不等于中序遍历中最后一个值
            //说明此时存在右节点
            //将右节点入栈
            if (node.value != inorder[inorderIndex]) {
                node.rightTreeNode = new TreeNode(postorderVal);
                stack.push(node.rightTreeNode);
            } else {
                //当栈顶元素==中序遍历的最后一个时，该节点没有右节点
                //反向中序遍历中 在这个节点后面的一定是左节点或者双亲节点
                //此时栈中的元素一定是该节点的双亲结点所以当反向中序遍历出现和栈中元素不相等时即是该节点的左节点
                while (!stack.isEmpty() && stack.peek().value == inorder[inorderIndex]) {
                    node = stack.pop();
                    System.out.println(" inorder[inorderIndex]" + inorder[inorderIndex]);
                    System.out.println(node.value);
                    inorderIndex--;
                }
                //将左节点入栈
                node.leftTreeNode = new TreeNode(postorderVal);
                stack.push(node.leftTreeNode);
            }
        }
        return root;
    }

    public TreeNode mySelf_constructingBinaryTreeInMiddleOrderAndPostOrder(int[] inorderArray, int[] postorderArray) {
        Stack<TreeNode> temporaryTreeNodePointStack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorderArray[postorderArray.length - 1]);
        temporaryTreeNodePointStack.push(root);
        int needErgodicOrderArrayLength = inorderArray.length - 2;
        int inorderArrayIndex = inorderArray.length - 1;
        for (int needErgodicOrderArrayLengthIndex = needErgodicOrderArrayLength; needErgodicOrderArrayLengthIndex >= 0; needErgodicOrderArrayLengthIndex--) {
            TreeNode currentPollTreeNodePoint = temporaryTreeNodePointStack.peek();
            int currentInorderArrayElement = inorderArray[inorderArrayIndex];
            int postorderArrayElement = postorderArray[needErgodicOrderArrayLengthIndex];
            if (currentPollTreeNodePoint.value != currentInorderArrayElement) {
                currentPollTreeNodePoint.rightTreeNode = new TreeNode(postorderArrayElement);
            } else {
                while (!temporaryTreeNodePointStack.isEmpty() && currentPollTreeNodePoint.value == currentInorderArrayElement) {
                    currentPollTreeNodePoint = temporaryTreeNodePointStack.pop();
                    inorderArrayIndex--;
                }
                currentPollTreeNodePoint.leftTreeNode = new TreeNode(postorderArrayElement);
                temporaryTreeNodePointStack.push(currentPollTreeNodePoint);

            }
        }
        return root;
    }


}
