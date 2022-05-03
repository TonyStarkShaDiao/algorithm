package com.src.algorithm.datastructure.mathematics.prod;

import com.src.algorithm.datastructure.nodes.prod.SumTwoLinkedLists;

/**
 * 找出游戏的胜利者
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/27
 */
public class FindTheWinnerOfTheCircularGame {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
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

    public int listNodeFindTheWinnerOfTheCircularGame(int numberOfPeople, int eliminationDigit) {
        ListNode head = new ListNode(1);
        ListNode currentPreviousListNode = head;
        for (int i = 2; i <= numberOfPeople; i++) {
            ListNode currentListNode = new ListNode(i);
            currentPreviousListNode.next = currentListNode;
            currentPreviousListNode = currentPreviousListNode.next;
        }
        currentPreviousListNode.next = head;
        while (head != null) {
            if (currentPreviousListNode.next == currentPreviousListNode) {
                return currentPreviousListNode.value;
            }
            for (int i = eliminationDigit; i > 1; i--) {
                currentPreviousListNode = currentPreviousListNode.next;
            }
            currentPreviousListNode.next = currentPreviousListNode.next.next;
        }
        return currentPreviousListNode.value;
    }

    public int mySelf_SecondListNodeFindTheWinnerOfTheCircularGame(int numberOfPeople, int eliminationDigit) {
        ListNode head = new ListNode(1);
        ListNode currentPreviousListNode = head;
        for (int number = 2; number <= numberOfPeople; number++) {
            ListNode currentListNode = new ListNode(number);
            currentPreviousListNode.next = currentListNode;
            currentPreviousListNode = currentPreviousListNode.next;
        }
        currentPreviousListNode.next = head;
        while (head != null) {
            if (currentPreviousListNode.next == currentPreviousListNode) {
                return currentPreviousListNode.value;
            }
            for (int i = eliminationDigit; i > 1; i--) {
                currentPreviousListNode = currentPreviousListNode.next;
            }
            currentPreviousListNode.next = currentPreviousListNode.next.next;
        }
        return currentPreviousListNode.value;
    }

}
