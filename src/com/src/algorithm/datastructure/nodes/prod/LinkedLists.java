package com.src.algorithm.datastructure.nodes.prod;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

/**
 * 链表
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/24
 */
public class LinkedLists {
    public int getSize() {
        return size;
    }

    private int size;
    private ListNode headerListNode;

    public LinkedLists() {
        size = 0;
        headerListNode = new ListNode(0);
    }

    public class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }


    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentListNode = headerListNode;
        for (int i = 0; i < index + 1; i++) {
            currentListNode = currentListNode.next;
        }

        return currentListNode.value;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size + 1) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode previousListNode = headerListNode;
        for (int i = 1; i < index; i++) {
            previousListNode = previousListNode.next;
        }
        ListNode needAddListNode = new ListNode(val);
        needAddListNode.next = previousListNode.next;
        previousListNode.next = needAddListNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) {
            return;
        }
        size--;
        ListNode previousListNode = headerListNode;
        for (int i = 0; i < index; ++i) {
            previousListNode = previousListNode.next;
        }
        previousListNode.next = previousListNode.next.next;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        ListNode currentListNode = headerListNode.next;
        while (currentListNode != null) {
            array[index] = currentListNode.value;
            currentListNode = currentListNode.next;
            index++;
        }
        return array;
    }
}
