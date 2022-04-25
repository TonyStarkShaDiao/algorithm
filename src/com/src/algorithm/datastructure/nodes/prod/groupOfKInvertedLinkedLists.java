package com.src.algorithm.datastructure.nodes.prod;

/**
 * k个一组反转链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/25
 */
public class groupOfKInvertedLinkedLists {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int index) {
            this.value = index;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
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

    public ListNode MySelf_GroupOfKInvertedLinkedLists(ListNode header, int numberOfGroups) {
        if (header == null || header.next == null) {
            return header;
        }
        ListNode dummyListNode = new ListNode(0, header);
        ListNode currentListNode = header;
        int listNodeLength = 0;
        while (currentListNode != null) {
            currentListNode = currentListNode.next;
            listNodeLength++;
        }
        int groupCount = listNodeLength / numberOfGroups;
        currentListNode = header;
        ListNode beforeGroupListNode = dummyListNode;
        ListNode afterGroupListNode = null;
        for (int i = 0; i < groupCount; i++) {
            int numberOfNodes = numberOfGroups;
            ListNode currentPreviousListNode = null;
            while (numberOfNodes != 0) {
                numberOfNodes--;
                ListNode tempListNode = currentListNode.next;
                currentListNode.next = currentPreviousListNode;
                currentPreviousListNode = currentListNode;
                currentListNode = tempListNode;
                afterGroupListNode = currentListNode;
            }
            beforeGroupListNode.next = currentPreviousListNode;
            while (currentPreviousListNode.next != null) {
                currentPreviousListNode = currentPreviousListNode.next;
            }
            currentPreviousListNode.next = afterGroupListNode;
            beforeGroupListNode = currentPreviousListNode;
            currentListNode = beforeGroupListNode.next;

        }
        return dummyListNode.next;
    }
}
