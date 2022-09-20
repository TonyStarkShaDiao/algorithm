package com.src.algorithm.datastructure.nodes.prod;

/**
 * 删除n链表倒数节点
 * <p>
 * <p>
 * <p>
 * 反转链表II
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/21
 */
public class DeleteTheReciprocalNodeOfTheLinkedListForN {
    public static class ListNode {
        public int value;
        public ListNode next;

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }

        public ListNode(int index) {
            this.value = index;
            next = null;
        }
    }

    @Deprecated
    public ListNode removeNthFromEnd(ListNode head, int NthToLast) {
        ListNode dummy = new ListNode(0);
        if (head.next == null) {
            return null;
        }
        dummy.next = head;
        int length = 1;
        ListNode LastNthNodes = null;
        ListNode previousLastNthNodes = null;
        while (head.next != null) {
            if (length + 1 == NthToLast) {
                length = 0;
                ListNode temporary = head;
                previousLastNthNodes = temporary;
                LastNthNodes = temporary.next;
                head = head.next;


            } else {
                length++;
                head = head.next;
            }


        }
        if (previousLastNthNodes != null || LastNthNodes != null) {
            previousLastNthNodes.next = LastNthNodes.next;
        }
        return dummy.next;
    }

    public ListNode mySelf_removeNthFromEnd(ListNode head, int NthToLast) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fastPoint = dummyNode;
        ListNode slowPoint = dummyNode;
        for (int linkedListIndex = 0; linkedListIndex < NthToLast; linkedListIndex++) {
            fastPoint = fastPoint.next;
        }
        while (fastPoint != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        slowPoint.next = slowPoint.next.next;
        return dummyNode.next;
    }


}
