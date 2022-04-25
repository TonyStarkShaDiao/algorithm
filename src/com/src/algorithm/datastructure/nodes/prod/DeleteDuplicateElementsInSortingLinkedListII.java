package com.src.algorithm.datastructure.nodes.prod;

/**
 * 删除排序链表ii中重复元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/25
 */
public class DeleteDuplicateElementsInSortingLinkedListII {
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

    //         //head = currentnode;
//        // 上一个privouvalue
//        //while(currentnode!=null)
//        //if head.value.==head.value&&head.value==privouvalue.value break
//        //head= head.next
//        //currentNode.next = head;
//        //currentnode =currentnode. next
//        //rerutn head
    public ListNode mySelf_DeleteDuplicateElementsInSortingLinkedListII(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHeader = new ListNode(-1, head);
        ListNode previousHeader = dummyHeader;
        while (head != null) {
            if (head.next != null && head.value == head.next.value) {
                while (head.next != null && head.value == head.next.value) {
                    head = head.next;
                }
                previousHeader.next = head.next;
            } else {
                previousHeader = previousHeader.next;
            }
            head = head.next;
        }

        return dummyHeader.next;
    }
}
