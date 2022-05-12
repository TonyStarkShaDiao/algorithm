package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.NextSortInArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NextSortInArrayTest {

    private NextSortInArray nextSortInArrayUnderTest;
    private int[] needAnalysisArray;
    private int[] expectedArray;


    @BeforeEach
    void setUp() {
        nextSortInArrayUnderTest = new NextSortInArray();
        needAnalysisArray = new int[]{1, 2, 3};
        expectedArray = new int[]{1, 3, 2};
    }

    @Test
    void testNextSort() {
        nextSortInArrayUnderTest.nextSort(needAnalysisArray);
        Assertions.assertArrayEquals(expectedArray, needAnalysisArray);
    }

    @Test
    void testMySelf_nextSort() {
        nextSortInArrayUnderTest.mySelf_nextSort(needAnalysisArray);
        Assertions.assertArrayEquals(expectedArray, needAnalysisArray);
    }
}
