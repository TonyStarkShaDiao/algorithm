package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.LinkedLists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {

    LinkedLists linkedLists;
    private int expectedQuantity;
    private int deleteExpectedQuantity;
    Object[] expectedHeaderArray;
    Object[] expectedTailArray;
    Object[] expectedIndexArray;
    Object[] deleteExpectedIndexArray;

    @BeforeEach
    void setUp() {
        linkedLists = new LinkedLists();
        expectedQuantity = 3;
        expectedHeaderArray = new Object[]{3, 2, 1};
        expectedTailArray = new Object[]{1, 2, 3};
        expectedIndexArray = new Object[]{4, 5, 6};
        deleteExpectedIndexArray = new Object[]{4, 5};
        deleteExpectedQuantity = 2;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void get() {
    }

    @Test
    void addAtHead() {
        linkedLists.addAtHead(1);
        linkedLists.addAtHead(2);
        linkedLists.addAtHead(3);
        assertEquals(expectedQuantity, linkedLists.getSize());
        assertArrayEquals(expectedHeaderArray, linkedLists.toArray());

    }

    @Test
    void addAtTail() {
        linkedLists.addAtTail(1);
        linkedLists.addAtTail(2);
        linkedLists.addAtTail(3);
        assertEquals(expectedQuantity, linkedLists.getSize());
        assertArrayEquals(expectedTailArray, linkedLists.toArray());

    }

    @Test
    void addAtIndex() {
        linkedLists.addAtIndex(1, 4);
        linkedLists.addAtIndex(2, 5);
        linkedLists.addAtIndex(3, 6);
        assertEquals(expectedQuantity, linkedLists.getSize());
        assertArrayEquals(expectedIndexArray, linkedLists.toArray());
    }

    @Test
    void deleteAtIndex() {
        linkedLists.addAtIndex(1, 4);
        linkedLists.addAtIndex(2, 5);
        linkedLists.addAtIndex(3, 6);
        linkedLists.deleteAtIndex(2);
        assertEquals(deleteExpectedQuantity, linkedLists.getSize());
        assertArrayEquals(deleteExpectedIndexArray, linkedLists.toArray());
    }
}