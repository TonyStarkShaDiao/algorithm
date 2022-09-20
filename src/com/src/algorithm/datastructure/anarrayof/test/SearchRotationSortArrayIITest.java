package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SearchRotationSortArrayII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchRotationSortArrayIITest {

    private SearchRotationSortArrayII searchRotationSortArrayIIUnderTest;
    int[] afterRotationArray;
    int rotateArrayElement;
    boolean expectArrayElementIndex;

    @BeforeEach
    void setUp() {
        searchRotationSortArrayIIUnderTest = new SearchRotationSortArrayII();
        afterRotationArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        rotateArrayElement = 2;
        expectArrayElementIndex = true;
    }

    @Test
    void testMySelf_binarySearchSearchRotationSortArrayII() {
        assertThat(searchRotationSortArrayIIUnderTest.mySelf_binarySearchSearchRotationSortArrayII(afterRotationArray, rotateArrayElement)).isEqualTo(true);
    }
}
