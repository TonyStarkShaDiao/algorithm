package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.TwoIntegerAdd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoIntegerAddTest {
    TwoIntegerAdd twoIntegerAdd;
    Object[] expectArray;
    int[] firstOneArray;
    int[] secondOneArray;
    Object[] twoArrayAddExpectArray;
    int integerValue;

    @BeforeEach
    void setUp() {
        firstOneArray = new int[]{1, 2, 0, 0};
        secondOneArray = new int[]{1, 2, 0, 0};
        twoIntegerAdd = new TwoIntegerAdd();
        expectArray = new Object[]{1, 2, 3, 4};
        integerValue = 34;
        twoArrayAddExpectArray = new Object[]{2, 4, 0, 0};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_TwoIntegerAdd() {
        List<Integer> integerArrayAddResult = twoIntegerAdd.mySelf_TwoIntegerAdd(firstOneArray, integerValue);
        assertArrayEquals(expectArray, integerArrayAddResult.toArray());
    }

    @Test
    void mySelf_TwoIntegerArrayAdd() {
        List<Integer> integers = twoIntegerAdd.mySelf_TwoIntegerArrayAdd(firstOneArray, secondOneArray);
        Object[] objects = integers.toArray();
        assertArrayEquals(twoArrayAddExpectArray, objects);
    }
}