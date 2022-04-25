package com.src.algorithm.datastructure.nodes.prod;

import java.util.List;

/**
 * 成对交换链表中节点
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/24
 */
public class ExchangeNodesInLinkedListInPairs {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
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

    public ListNode MySelf_ExchangeNodesInLinkedListInPairs(ListNode headListNode) {
        ListNode temporaryListNode = new ListNode(0, headListNode);
        ListNode currentListNode = temporaryListNode;
        while (currentListNode.next != null && currentListNode.next.next != null) {
//          firstListNode=  1>2>3>4>null
            ListNode firstListNode = currentListNode.next;
            //secondListNode=2>3>4>null
            ListNode secondListNode = currentListNode.next.next;
            //把当前节点指针的下一个节点指向指向第三个节点
            // currentListNode=2>3>4>null
            currentListNode.next = secondListNode;
            //把第一个节点的下一个节点的指针指向第二个节点的下一个节点
            //firstListNode =1>3>4>null
            firstListNode.next = secondListNode.next;
            //把第二个节点指针链接到第一个节点
            //secondListNode=2<1>3>4>null
            secondListNode.next = firstListNode;
            //最后异步吧当前节点指针指向下一个节点
            //1>3>4>null
            currentListNode = firstListNode;
        }
        return temporaryListNode.next;
    }

    public ListNode MySelf_SecondExchangeNodesInLinkedListInPairs(ListNode headListNode) {
        ListNode temporaryListNode = new ListNode(0, headListNode);
        ListNode currentListNode = temporaryListNode;
        while (currentListNode.next != null && currentListNode.next.next != null) {
            ListNode firstListNode = currentListNode.next;
            ListNode secondListNode = currentListNode.next.next;
            currentListNode.next = secondListNode;
            firstListNode.next = secondListNode.next;
            secondListNode.next = firstListNode;
            currentListNode = firstListNode;
        }

        return temporaryListNode.next;
    }


}

