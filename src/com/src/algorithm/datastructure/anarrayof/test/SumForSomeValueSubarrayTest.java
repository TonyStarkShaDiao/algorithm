package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SumForSomeValueSubarray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumForSomeValueSubarrayTest {

    private SumForSomeValueSubarray sumForSomeValueSubarray;
    int expectFoundSubarrayCount;
    int comparingValues;
    int[] needFoundArray;

    @BeforeEach
    void setUp() {
        sumForSomeValueSubarray = new SumForSomeValueSubarray();
        needFoundArray = new int[]{1, 1, 1};
        expectFoundSubarrayCount = 2;
        comparingValues = 2;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_HashSumForSomeValueSubarray() {
        int needCheckSubArrayCount = sumForSomeValueSubarray.mySelf_HashSumForSomeValueSubarray(needFoundArray, comparingValues);
        assertEquals(expectFoundSubarrayCount, needCheckSubArrayCount);
    }
}