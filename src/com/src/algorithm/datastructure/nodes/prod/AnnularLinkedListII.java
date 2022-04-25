package com.src.algorithm.datastructure.nodes.prod;

/**
 * 环形链表2
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/22
 */
public class AnnularLinkedListII {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof SumTwoLinkedLists.ListNode) {
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
     * 找到环形 链表的入口点
     *
     * @param headerListNode
     * @return
     */
    public ListNode mySelf_freudianAlgorithmAnnularLinkedListII(ListNode headerListNode) {
        ListNode slowPoint = headerListNode;
        ListNode fastPoint = headerListNode;
        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if (slowPoint == fastPoint) {
                fastPoint = headerListNode;
                while (slowPoint != fastPoint) {
                    slowPoint = slowPoint.next;
                    fastPoint = fastPoint.next;
                }
                return slowPoint;
            }
        }
        return null;
    }
}
