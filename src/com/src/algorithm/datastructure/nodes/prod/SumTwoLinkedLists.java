package com.src.algorithm.datastructure.nodes.prod;

import com.sun.org.apache.regexp.internal.RE;
import sun.util.resources.cldr.my.CurrencyNames_my;

/**
 * 两个链表之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/21
 */
public class SumTwoLinkedLists {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        @Override
        public int hashCode() {
            return super.hashCode();
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

        public ListNode(int val) {
            this.value = val;
        }

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }

    public ListNode mySelf_SumTwoLinkedLists(ListNode firstListHeaderNode, ListNode secondHeaderListNode) {
        int carry = 0;
        ListNode resultHeaderNode = new ListNode(0);
        ListNode nextNode = resultHeaderNode;
        while (firstListHeaderNode != null || secondHeaderListNode != null) {
            int currentFirstListNodeValue = firstListHeaderNode == null ? 0 : firstListHeaderNode.value;
            int currentSecondListNodeValue = secondHeaderListNode == null ? 0 : secondHeaderListNode.value;
            int sumOfAdditionResults = currentFirstListNodeValue + currentSecondListNodeValue + carry;
            carry = sumOfAdditionResults / 10;
            nextNode.next = new ListNode(sumOfAdditionResults % 10);
            nextNode = nextNode.next;
            firstListHeaderNode = firstListHeaderNode == null ? null : firstListHeaderNode.next;
            secondHeaderListNode = secondHeaderListNode == null ? null : secondHeaderListNode.next;
        }
        if (carry > 0) {
            nextNode.next = new ListNode(carry);
        }
        return resultHeaderNode.next;
    }


}
