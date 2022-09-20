package com.src.algorithm.datastructure.nodes.prod;

/**
 * 合并两个订单节点列表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/16
 */
public class MergingTwoOrderNodeList {


    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.value = val;
        }

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof ListNode) {
                ListNode node = (ListNode) obj;
                ListNode tempListNode = new ListNode(value);
                tempListNode.next = next;
                while (node != null) {
                    System.out.println(tempListNode.value);
                    if (node.value != tempListNode.value) {
                        return false;
                    }
                    node = node.next;
                    tempListNode = tempListNode.next;
                }
            }
            return true;
        }


    }

    /**
     * 我临时节点合并两个列表
     *
     * @param firstOneListNode 第一个列表节点
     * @param secondListNode   第二个列表节点
     * @return {@link ListNode}
     */
    public ListNode mySelf_TemporaryNodeMergeTwoLists(ListNode firstOneListNode, ListNode secondListNode) {
        ListNode listNode = new ListNode(-1);
        ListNode temporaryNode = listNode;
        while (firstOneListNode != null && secondListNode != null) {
            if (firstOneListNode.value <= secondListNode.value) {
                temporaryNode.next = firstOneListNode;
                firstOneListNode = firstOneListNode.next;
            } else {
                temporaryNode.next = secondListNode;
                secondListNode = secondListNode.next;
            }
            temporaryNode = temporaryNode.next;
        }
        temporaryNode.next = firstOneListNode == null ? secondListNode : firstOneListNode;
        return listNode.next;
    }

    /**
     * 我自己递归节点合并两个列表
     *
     * @return {@link ListNode}
     */
    public ListNode mySelf_RecursiveNodeMergeTwoLists(ListNode firstOneListNode, ListNode secondListNode) {
        if (firstOneListNode == null) {
            return secondListNode;
        } else if (secondListNode == null) {
            return firstOneListNode;
        } else if (firstOneListNode.value > secondListNode.value) {
            secondListNode.next = mySelf_RecursiveNodeMergeTwoLists(firstOneListNode, secondListNode.next);
            return secondListNode;
        } else {
            firstOneListNode.next = mySelf_RecursiveNodeMergeTwoLists(firstOneListNode.next, secondListNode);
            return firstOneListNode;
        }

    }

    public ListNode mySelf_SecondTemporaryListNodeMergeTwoLists(ListNode firstOneListNode, ListNode secondListNode) {
        ListNode temporary = new ListNode(-1);
        ListNode temporaryNode = temporary;
        while (firstOneListNode != null && secondListNode != null) {
            if (firstOneListNode.value <= secondListNode.value) {
                temporaryNode.next = firstOneListNode;
                firstOneListNode = firstOneListNode.next;
            } else {
                temporaryNode.next = secondListNode;
                secondListNode = secondListNode.next;
            }
            temporaryNode = temporaryNode.next;
        }

        temporaryNode.next = firstOneListNode == null ? secondListNode : firstOneListNode;
        return temporary.next;
    }

}

//    ListNode prehead = new ListNode(-1);
//
//    ListNode prev = prehead;
//        while (l1 != null && l2 != null) {
//                if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//                } else {
//                prev.next = l2;
//                l2 = l2.next;
//                }
//                prev = prev.next;
//                }
//
//                // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
//                prev.next = l1 == null ? l2 : l1;
//
//                return prehead.next;
//                }