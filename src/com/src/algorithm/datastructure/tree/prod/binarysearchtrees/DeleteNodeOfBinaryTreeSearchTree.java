package com.src.algorithm.datastructure.tree.prod.binarysearchtrees;

/**
 * 删除二叉树搜索树节点
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/04
 * 二叉搜索树中第K小的元素
 */
public class DeleteNodeOfBinaryTreeSearchTree {
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

    public BinarySearchTreeNode middleOrderTraversalDeleteNodeOfBinaryTreeSearchTree(BinarySearchTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode currentTreeNodePoint = root;
        BinarySearchTreeNode previousTreeNodePoint = null;
        while (currentTreeNodePoint != null) {

            if (currentTreeNodePoint.value == key) {
                break;
            }
            previousTreeNodePoint = currentTreeNodePoint;
            if (currentTreeNodePoint.value > key) {
                currentTreeNodePoint = currentTreeNodePoint.leftTreeNode;
            }
            if (currentTreeNodePoint.value < key) {
                currentTreeNodePoint = currentTreeNodePoint.rightTreeNode;
            }
        }
        if (previousTreeNodePoint == null) {
            return this.deleteTreeNode(currentTreeNodePoint);
        }
        if (previousTreeNodePoint.leftTreeNode != null && previousTreeNodePoint.leftTreeNode.value == key) {
            previousTreeNodePoint.leftTreeNode = this.deleteTreeNode(currentTreeNodePoint);

        }
        if (previousTreeNodePoint.rightTreeNode != null && previousTreeNodePoint.rightTreeNode.value == key) {
            previousTreeNodePoint.rightTreeNode = this.deleteTreeNode(currentTreeNodePoint);
        }
        return root;

    }


    private BinarySearchTreeNode deleteTreeNode(BinarySearchTreeNode currentTreeNodePoint) {
        if (currentTreeNodePoint == null) {
            return null;
        }
        if (currentTreeNodePoint.rightTreeNode == null) {
            return currentTreeNodePoint.leftTreeNode;
        }
        BinarySearchTreeNode currentRightTreeNodePoint = currentTreeNodePoint.rightTreeNode;
        while (currentRightTreeNodePoint.leftTreeNode != null) {
            currentRightTreeNodePoint = currentRightTreeNodePoint.leftTreeNode;
        }
        currentRightTreeNodePoint.leftTreeNode = currentTreeNodePoint.leftTreeNode;
        return currentTreeNodePoint.rightTreeNode;
    }

    public BinarySearchTreeNode iterationDeleteNodeOfBinaryTreeSearchTree(BinarySearchTreeNode root, int delElement) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode previousTreeNode = null, currentTreeNode = root;
        while (currentTreeNode != null && currentTreeNode.value != delElement) {
            previousTreeNode = currentTreeNode;
            if (currentTreeNode.value > delElement) {
                currentTreeNode = currentTreeNode.leftTreeNode;
            } else if (currentTreeNode.value < delElement) {
                currentTreeNode = currentTreeNode.rightTreeNode;
            }
        }
        if (currentTreeNode != null) {
            if (previousTreeNode != null) {
                if (previousTreeNode.leftTreeNode == currentTreeNode) {
                    previousTreeNode.leftTreeNode = this.delete(currentTreeNode);
                } else {
                    previousTreeNode.rightTreeNode = this.delete(currentTreeNode);
                }
            } else {
                root = this.delete(currentTreeNode);
            }
        } else {
            // no find element in tree
            return root;
        }
        return root;
    }

    private BinarySearchTreeNode delete(BinarySearchTreeNode currentTreeNode) {
        if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
            return null;
        } else if (currentTreeNode.rightTreeNode == null) {
            currentTreeNode = currentTreeNode.leftTreeNode;
        } else if (currentTreeNode.leftTreeNode == null) {
            currentTreeNode = currentTreeNode.rightTreeNode;
        } else {
            BinarySearchTreeNode newRootTreeNode = currentTreeNode.rightTreeNode, newPreviousTreeNode = null;
            while (newRootTreeNode.leftTreeNode != null) {
                newPreviousTreeNode = newRootTreeNode;
                newRootTreeNode = newRootTreeNode.leftTreeNode;
            }
            if (currentTreeNode.rightTreeNode != newRootTreeNode) {
                newPreviousTreeNode.leftTreeNode = newRootTreeNode.rightTreeNode;
                newRootTreeNode.rightTreeNode = currentTreeNode.rightTreeNode;
            }
            newRootTreeNode.leftTreeNode = currentTreeNode.leftTreeNode;
            currentTreeNode = newRootTreeNode;
        }
        return currentTreeNode;
    }

    public BinarySearchTreeNode deleteNode(BinarySearchTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return delete(root, key);
    }

    /**
     * 删除，三种情况
     * 1. 目标节点没有左右子树，直接删除
     * 2. 目标节点只有左子树或只有右子树，原来指向目标节点的指针指向其左子树或右子树
     * 3. 目标节点有左右子树:
     * 方案一：找到左子树的最右节点，让原来指向这个左子树最右节点的指针指向其左子树，然后用这个左子树最右节点替换掉目标节点
     * 方案二：找到右子树的最左节点，让原来指向这个右子树最左节点的指向指向其右子树，然后用这个右子树最左节点替换掉目标节点
     *
     * @param root 根节点
     * @param key  待删除节点值
     * @return 新的根节点
     */
    private BinarySearchTreeNode delete(BinarySearchTreeNode root, int key) {
        // 找到要删除的节点
        BinarySearchTreeNode 要删除节点上一个节点 = null, 需要删除节点的树 = root;
        while (需要删除节点的树 != null && 需要删除节点的树.value != key) {
            要删除节点上一个节点 = 需要删除节点的树;
            if (需要删除节点的树.value > key) {
                需要删除节点的树 = 需要删除节点的树.leftTreeNode;
            } else {
                需要删除节点的树 = 需要删除节点的树.rightTreeNode;
            }
        }
        // 找不到
        if (需要删除节点的树 == null) {
            return root;
        }
        BinarySearchTreeNode 新的节点 = null;
        // 第一、第二种情况
        if (需要删除节点的树.leftTreeNode == null || 需要删除节点的树.rightTreeNode == null) {
            if (需要删除节点的树.leftTreeNode == null) {
                新的节点 = transplant(要删除节点上一个节点, 需要删除节点的树, 需要删除节点的树.rightTreeNode);
            }
            if (需要删除节点的树.rightTreeNode == null) {
                新的节点 = transplant(要删除节点上一个节点, 需要删除节点的树, 需要删除节点的树.leftTreeNode);
            }
            if (要删除节点上一个节点 == null) {
                return 新的节点;
            }
            return root;
        }
        // 第三种情况
        BinarySearchTreeNode 最小的节点的上一个节点 = 需要删除节点的树, 最小的节点 = 需要删除节点的树.rightTreeNode;
        while (最小的节点.leftTreeNode != null) {
            最小的节点的上一个节点 = 最小的节点;
            最小的节点 = 最小的节点.leftTreeNode;
        }
        // no treeNode left
        if (最小的节点 == 需要删除节点的树.rightTreeNode) {
            新的节点 = transplant(要删除节点上一个节点, 需要删除节点的树, 最小的节点);
        } else {
            transplant(最小的节点的上一个节点, 最小的节点, 最小的节点.rightTreeNode);
            新的节点 = transplant(要删除节点上一个节点, 需要删除节点的树, 最小的节点);
            新的节点.rightTreeNode = 需要删除节点的树.rightTreeNode;
        }
        新的节点.leftTreeNode = 需要删除节点的树.leftTreeNode;
        return 要删除节点上一个节点 == null ? 新的节点 : root;
    }

    private BinarySearchTreeNode transplant(BinarySearchTreeNode 父节点, BinarySearchTreeNode 要删除的节点, BinarySearchTreeNode 新的节点) {
        if (父节点 == null) {
            return 新的节点;
        }
        if (父节点.leftTreeNode == 要删除的节点) {
            父节点.leftTreeNode = 新的节点;
        } else if (父节点.rightTreeNode == 要删除的节点) {
            父节点.rightTreeNode = 新的节点;
        }
        return 新的节点;
    }

    public BinarySearchTreeNode mySelf_secondIteration(BinarySearchTreeNode root, int delElement) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode temporaryRoot = root, currentPreviousNode = null;
        while (temporaryRoot != null && temporaryRoot.value != delElement) {
            currentPreviousNode = temporaryRoot;
            if (temporaryRoot.value > delElement) {
                temporaryRoot = temporaryRoot.leftTreeNode;
            } else if (temporaryRoot.value < delElement) {
                temporaryRoot = temporaryRoot.rightTreeNode;
            }
        }
        if (temporaryRoot == null) {
            return root;
        }
        BinarySearchTreeNode newTreeNode = null;
        if (temporaryRoot.leftTreeNode == null || temporaryRoot.rightTreeNode == null) {
            if (temporaryRoot.leftTreeNode == null) {
                newTreeNode = this.replaceTreeNode(currentPreviousNode, temporaryRoot, temporaryRoot.rightTreeNode);
            }
            if (temporaryRoot.rightTreeNode == null) {
                newTreeNode = this.replaceTreeNode(currentPreviousNode, temporaryRoot, temporaryRoot.leftTreeNode);
            }
            if (currentPreviousNode == null) {
                return newTreeNode;
            }
            return root;
        } else {
            BinarySearchTreeNode minTreeNodePreviousTreeNode = temporaryRoot, minTreeNode = temporaryRoot.rightTreeNode;
            while (minTreeNode.leftTreeNode != null) {
                minTreeNodePreviousTreeNode = minTreeNode;
                minTreeNode = minTreeNode.leftTreeNode;
            }
            if (temporaryRoot.rightTreeNode == minTreeNode) {
                newTreeNode = this.replaceTreeNode(currentPreviousNode, temporaryRoot, minTreeNode);
            } else {
                //clear minTreeNodePreviousTreeNode.leftTreeNode
                this.replaceTreeNode(minTreeNodePreviousTreeNode, minTreeNode, minTreeNode.rightTreeNode);
                newTreeNode = this.replaceTreeNode(currentPreviousNode, temporaryRoot, minTreeNode);
                newTreeNode.rightTreeNode = temporaryRoot.rightTreeNode;
            }
            newTreeNode.leftTreeNode = temporaryRoot.leftTreeNode;
            return currentPreviousNode == null ? newTreeNode : root;
        }
    }

    private BinarySearchTreeNode replaceTreeNode(BinarySearchTreeNode PreviousNode, BinarySearchTreeNode delTreeNode, BinarySearchTreeNode newTreeNode) {
        if (PreviousNode == null) {
            return newTreeNode;
        }
        if (PreviousNode.leftTreeNode == delTreeNode) {
            PreviousNode.leftTreeNode = newTreeNode;
        } else if (PreviousNode.rightTreeNode == delTreeNode) {
            PreviousNode.rightTreeNode = newTreeNode;
        }
        return newTreeNode;
    }

    /**
     * 删除，三种情况
     * 1. 目标节点没有左右子树，直接删除
     * 2. 目标节点只有左子树或只有右子树，原来指向目标节点的指针指向其左子树或右子树
     * 3. 目标节点有左右子树:
     * 方案一：找到左子树的最右节点，让原来指向这个左子树最右节点的指针指向其左子树，然后用这个左子树最右节点替换掉目标节点
     * 方案二：找到右子树的最左节点，让原来指向这个右子树最左节点的指向指向其右子树，然后用这个右子树最左节点替换掉目标节点
     */
    public BinarySearchTreeNode deleteNode2(BinarySearchTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode pre = null, cur = root;
        while (cur != null && cur.value != key) {
            pre = cur;
            if (cur.value > key) {
                cur = cur.leftTreeNode;
            } else {
                cur = cur.rightTreeNode;
            }
        }
        if (cur != null) {
            if (pre != null) {
                if (pre.leftTreeNode == cur) {
                    pre.leftTreeNode = delete2(cur);
                } else {
                    pre.rightTreeNode = delete2(cur);
                }
            } else {
                root = delete2(cur);
            }
        }
        return root;
    }

    private BinarySearchTreeNode delete2(BinarySearchTreeNode cur) {
        if (cur.leftTreeNode == null && cur.rightTreeNode == null) {
            cur = null;
        } else if (cur.leftTreeNode == null) {
            cur = cur.rightTreeNode;
        } else if (cur.rightTreeNode == null) {
            cur = cur.leftTreeNode;
        } else {
            BinarySearchTreeNode newNode = cur.rightTreeNode, newNodePre = null;
            while (newNode.leftTreeNode != null) {
                newNodePre = newNode;
                newNode = newNode.leftTreeNode;
            }
            if (cur.rightTreeNode != newNode) {
                newNodePre.rightTreeNode = newNode.rightTreeNode;
                newNode.rightTreeNode = cur.rightTreeNode;
            }
            newNode.leftTreeNode = cur.leftTreeNode;
            cur = newNode;
        }
        return cur;
    }

    public BinarySearchTreeNode mySelf_thirdIteration(BinarySearchTreeNode root, int elementKey) {
        BinarySearchTreeNode currentTreeNode = root;
        BinarySearchTreeNode previousTreeNode = null;
        while (currentTreeNode != null && currentTreeNode.value != elementKey) {
            previousTreeNode = currentTreeNode;
            if (elementKey > currentTreeNode.value) {
                currentTreeNode = currentTreeNode.rightTreeNode;
            } else {
                currentTreeNode = currentTreeNode.leftTreeNode;
            }

        }
        if (currentTreeNode != null) {
            if (previousTreeNode != null) {
                if (previousTreeNode.leftTreeNode == currentTreeNode) {
                    previousTreeNode.leftTreeNode = this.deleteNodeAndReturnNewTreeNode(currentTreeNode);
                } else {
                    previousTreeNode.rightTreeNode = this.deleteNodeAndReturnNewTreeNode(currentTreeNode);
                }
            } else {
                root = this.deleteNodeAndReturnNewTreeNode(currentTreeNode);
            }
        }
        return root;
    }

    private BinarySearchTreeNode deleteNodeAndReturnNewTreeNode(BinarySearchTreeNode currentTreeNode) {
        if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
            currentTreeNode = null;
        } else if (currentTreeNode.leftTreeNode == null) {
            currentTreeNode = currentTreeNode.rightTreeNode;
        } else if (currentTreeNode.rightTreeNode == null) {
            currentTreeNode = currentTreeNode.leftTreeNode;
        } else {
            BinarySearchTreeNode newTreeNode = currentTreeNode.rightTreeNode, newPreviousTreeNode = null;
            while (newTreeNode.leftTreeNode != null) {
                newPreviousTreeNode = newTreeNode;
                newTreeNode = newTreeNode.leftTreeNode;
            }
            if (currentTreeNode.rightTreeNode != newTreeNode) {
                // 将右子树的最小节点替换成同父节点的右子树
                newPreviousTreeNode.leftTreeNode = newTreeNode.rightTreeNode;
                newTreeNode.rightTreeNode = currentTreeNode.rightTreeNode;
            }
            newTreeNode.leftTreeNode = currentTreeNode.leftTreeNode;
            currentTreeNode = newTreeNode;
        }
        return currentTreeNode;
    }

    public BinarySearchTreeNode mySelf_fourthIterationDeleteTreeNodeElement(BinarySearchTreeNode root, int delElement) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode currentTreeNode = root;
        BinarySearchTreeNode previousTreeNode = null;
        while (currentTreeNode != null && currentTreeNode.value != delElement) {
            previousTreeNode = currentTreeNode;
            if (delElement > currentTreeNode.value) {
                currentTreeNode = currentTreeNode.rightTreeNode;
            } else {
                currentTreeNode = currentTreeNode.leftTreeNode;
            }
        }
        if (currentTreeNode != null) {
            if (previousTreeNode != null) {
                if (previousTreeNode.leftTreeNode == currentTreeNode) {
                    previousTreeNode.leftTreeNode = this.mySelf_deleteNodeAndReturnNewTreeNode(currentTreeNode);
                } else {
                    previousTreeNode.rightTreeNode = this.mySelf_deleteNodeAndReturnNewTreeNode(currentTreeNode);
                }
            } else {
                root = this.deleteNodeAndReturnNewTreeNode(currentTreeNode);
            }
        }
        return root;
    }

    private BinarySearchTreeNode mySelf_deleteNodeAndReturnNewTreeNode(BinarySearchTreeNode currentTreeNode) {
        if (currentTreeNode.leftTreeNode == null && currentTreeNode.rightTreeNode == null) {
            currentTreeNode = null;
        } else if (currentTreeNode.leftTreeNode == null) {
            currentTreeNode = currentTreeNode.rightTreeNode;
        } else if (currentTreeNode.rightTreeNode == null) {
            currentTreeNode = currentTreeNode.leftTreeNode;
        } else {
            BinarySearchTreeNode minTreeNode = currentTreeNode.rightTreeNode, previousMinTreeNode = null;
            while (minTreeNode.leftTreeNode != null) {
                previousMinTreeNode = minTreeNode;
                minTreeNode = minTreeNode.leftTreeNode;
            }
            if (currentTreeNode.rightTreeNode != minTreeNode) {
                previousMinTreeNode.rightTreeNode = minTreeNode.rightTreeNode;
                minTreeNode.rightTreeNode = currentTreeNode.rightTreeNode;
            }
            minTreeNode.leftTreeNode = currentTreeNode.leftTreeNode;
            currentTreeNode = minTreeNode;
        }
        return currentTreeNode;
    }


}
